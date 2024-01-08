Português

```markdown
# Documentação do Código

## Variáveis

### `public_key`
É uma chave SSH pública que permite que você faça login na nova instância. Por exemplo, você pode gerá-la usando o comando `cat ~/.ssh/id_rsa.pub`.

### `region`
Define a região em que a instância será criada. O valor padrão é "us-west-1", que se refere à região oeste dos Estados Unidos na Amazon Web Services.

### `vpc_cidr`
Define o bloco CIDR (Classless Inter-Domain Routing) para a VPC (Virtual Private Cloud). O valor padrão é "10.42.0.0/16", que aloca um espaço de endereço IP privado na rede virtual.

### `subnet_cidr`
Define o bloco CIDR para a sub-rede dentro da VPC. O valor padrão é "10.42.0.0/24". Este bloco CIDR é um subconjunto do bloco CIDR da VPC, representando um espaço de endereço IP mais específico dentro da rede virtual.
```