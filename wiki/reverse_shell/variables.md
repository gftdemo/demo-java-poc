# Documentação do Código

O código a seguir é escrito em Terraform, uma linguagem de infraestrutura como código (IaC), que permite definir e fornecer infraestrutura de data center usando uma linguagem de programação de alto nível.

## Variáveis

### `public_key`

```terraform
variable "public_key" {
  description = "Public SSH key to allow you to login to the new instance. e.g. cat ~/.ssh/id_rsa.pub"
}
```

Esta variável é usada para armazenar a chave pública SSH que permite o login na nova instância. Um exemplo de como obter essa chave seria usando o comando `cat ~/.ssh/id_rsa.pub` em um terminal Unix.

### `region`

```terraform
variable "region" {
  default = "us-west-1"
}
```

A variável `region` define a região AWS padrão onde a infraestrutura será provisionada. O valor padrão é `us-west-1`, que se refere à região norte da Califórnia.

### `vpc_cidr`

```terraform
variable "vpc_cidr" {
  default = "10.42.0.0/16"
}
```

A variável `vpc_cidr` é usada para definir o bloco de endereços IP para a VPC (Virtual Private Cloud) na AWS. O valor padrão é `10.42.0.0/16`, que permite até 65.536 endereços IP privados na VPC.

### `subnet_cidr`

```terraform
variable "subnet_cidr" {
  default = "10.42.0.0/24"
}
```

A variável `subnet_cidr` define o bloco de endereços IP para a sub-rede dentro da VPC. O valor padrão é `10.42.0.0/24`, que permite até 256 endereços IP privados na sub-rede.