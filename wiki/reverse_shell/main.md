# Documentação do Código Terraform

Este código é um script Terraform que configura uma infraestrutura na Amazon Web Services (AWS). 

## Provedor

```
provider "aws"  {
  region = "${var.region}"
}
```
Define o provedor como AWS e a região é especificada por uma variável.

## Recursos

### VPC

```
resource "aws_vpc" "main" {
  cidr_block = "${var.vpc_cidr}"
  tags = {
    Name = "tmp_vulnado_rev_shell_vpc"
  }
}
```
Cria um VPC (Virtual Private Cloud) com um bloco CIDR especificado. Ele é identificado pela tag "tmp_vulnado_rev_shell_vpc".

### Internet Gateway

```
resource "aws_internet_gateway" "gw" {
  vpc_id = "${aws_vpc.main.id}"
  tags = {
    Name = "tmp_vulnado_rev_shell_igw"
  }
}
```
Cria um Internet Gateway dentro do VPC criado anteriormente, permitindo a comunicação entre a VPC e a internet.

### Route Table

```
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
Cria uma tabela de roteamento na VPC. As rotas definem como o tráfego deve ser direcionado. Neste caso, todo o tráfego (0.0.0.0/0) é direcionado para o Internet Gateway.

### Subnet

```
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
Cria uma sub-rede dentro do VPC. Define a zona de disponibilidade e mapeia um IP público no lançamento da instância.

### Route Table Association

```
resource "aws_route_table_association" "assoc" {
  subnet_id      = "${aws_subnet.subnet.id}"
  route_table_id = "${aws_route_table.r.id}"
}
```
Associa a tabela de roteamento com a sub-rede.

### Security Group

```
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
Cria um grupo de segurança que permite tráfego ingresso nas portas 22 (SSH) e 443 (HTTPS) de qualquer lugar (0.0.0.0/0) e permite todo o tráfego de saída.

### AMI

```
data "aws_ami" "amznlinux" {
  most_recent = true
  owners = ["amazon"]

  filter {
    name   = "name"
    values = ["amzn2-ami-hvm-2.0.20181114-x86_64-gp2"]
  }
}
```
Seleciona a mais recente Amazon Machine Image (AMI) para Amazon Linux.

### Key Pair

```
resource "aws_key_pair" "attacker" {
  key_name   = "tmp-vulnado-deploy-key"
  public_key = "${var.public_key}"
}
```
Cria um par de chaves para autenticação SSH na instância EC2.

### EC2 Instance

```
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
Cria uma instância EC2 usando a AMI do Amazon Linux, no tipo de instância t2.micro, na sub-rede criada, usando o par de chaves para autenticação. Ele também atualiza o sistema e instala o nmap usando um script de inicialização.