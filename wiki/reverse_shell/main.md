# Documentação do Código Terraform

Este é um código Terraform que está configurando uma infraestrutura básica na AWS. 

```terraform
provider "aws"  {
  region = "${var.region}"
}
```
Primeiramente, definimos o provedor AWS e a região onde os recursos serão criados.

```terraform
resource "aws_vpc" "main" {
  cidr_block = "${var.vpc_cidr}"
  tags = {
    Name = "tmp_vulnado_rev_shell_vpc"
  }
}
```
Criamos uma VPC (Virtual Private Cloud) na AWS com um bloco de CIDR especificado.

```terraform
resource "aws_internet_gateway" "gw" {
  vpc_id = "${aws_vpc.main.id}"
  tags = {
    Name = "tmp_vulnado_rev_shell_igw"
  }
}
```
Um Internet Gateway é criado e associado à VPC.

```terraform
resource "aws_route_table" "r" {
  vpc_id = "${aws_vpc.main.id}"
  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = "${aws_internet_gateway.gw.id}"
  }
  tags = {
    Name = "tmp_vulnado_rev_shell_rt"
  }
}
```
Uma tabela de roteamento é criada para a VPC, com uma rota que direciona todo o tráfego (0.0.0.0/0) para o Internet Gateway.

```terraform
resource "aws_subnet" "subnet" {
  vpc_id     = "${aws_vpc.main.id}"
  cidr_block = "${var.subnet_cidr}"
  availability_zone = "${var.region}b"
  map_public_ip_on_launch = true
  tags = {
    Name = "tmp_vulnado_rev_shell_subnet"
  }
}
```
Uma sub-rede é criada dentro da VPC com um bloco CIDR específico. A sub-rede está localizada em uma zona de disponibilidade específica.

```terraform
resource "aws_route_table_association" "assoc" {
  subnet_id      = "${aws_subnet.subnet.id}"
  route_table_id = "${aws_route_table.r.id}"
}
```
A tabela de roteamento é associada à sub-rede.

```terraform
resource "aws_security_group" "sg" {
  name        = "tmp_vulnado_rev_shell_sg"
  vpc_id      = "${aws_vpc.main.id}"
  ingress {
    protocol    = "tcp"
    from_port   = 22
    to_port     = 22
    cidr_blocks = ["0.0.0.0/0"]
  }
  ingress {
    protocol    = "tcp"
    from_port   = 443
    to_port     = 443
    cidr_blocks = ["0.0.0.0/0"]
  }
  egress {
    from_port = 0
    to_port   = 0
    protocol  = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}
```
Um grupo de segurança é criado com regras de entrada e saída. As regras de entrada permitem tráfego TCP nas portas 22 e 443 de qualquer endereço (0.0.0.0/0). A regra de saída permite todo o tráfego para qualquer endereço.

```terraform
data "aws_ami" "amznlinux" {
  most_recent = true
  owners = ["amazon"]
  filter {
    name   = "name"
    values = ["amzn2-ami-hvm-2.0.20181114-x86_64-gp2"]
  }
}
```
Um AMI (Amazon Machine Image) é selecionado para ser usado na instância EC2. O mais recente é escolhido a partir de uma lista de proprietários e filtros específicos.

```terraform
resource "aws_key_pair" "attacker" {
  key_name   = "tmp-vulnado-deploy-key"
  public_key = "${var.public_key}"
}
```
Um par de chaves é criado para permitir o acesso SSH à instância EC2.

```terraform
resource "aws_instance" "receiver" {
  ami           = "${data.aws_ami.amznlinux.id}"
  instance_type = "t2.micro"
  subnet_id = "${aws_subnet.subnet.id}"
  key_name = "${aws_key_pair.attacker.key_name}"
  vpc_security_group_ids = ["${aws_security_group.sg.id}"]
  user_data = <<EOF
#!/bin/bash
yum update
yum install -y nmap
EOF
  tags = {
    Name = "VulnadoReverseShellReceiver"
  }
}
```
Finalmente, uma instância EC2 é criada com o AMI selecionado, o tipo de instância t2.micro, na sub-rede criada anteriormente, associada ao par de chaves e ao grupo de segurança. A instância também tem um script de inicialização que atualiza o sistema e instala o nmap.