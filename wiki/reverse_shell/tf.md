Português

```markdown
# Documentação do Código

Este é um script Bash que executa uma série de ações relacionadas à infraestrutura de computação em nuvem usando Terraform e Amazon Web Services (AWS).

## Código

```bash
#!/bin/bash

TF_VAR_public_key=$(cat ~/.ssh/id_rsa.pub) terraform $@
echo
echo ===================
echo === SSH Command ===
echo ===================
echo ssh ec2-user@$(aws --region us-west-1 ec2 describe-instances --filters  "Name=tag:Name,Values=VulnadoReverseShellReceiver" | jq -r '.Reservations[0].Instances[0]|.PublicIpAddress')
```

## Descrição

1. `TF_VAR_public_key=$(cat ~/.ssh/id_rsa.pub) terraform $@`: Este comando executa o Terraform com uma variável de ambiente `TF_VAR_public_key`, que é definida como a chave pública do usuário atual. O `$@` no final é uma variável especial do Bash que representa todos os argumentos de linha de comando fornecidos ao script.

2. `echo === SSH Command ===`: Este comando simplesmente imprime a string `=== SSH Command ===` no terminal.

3. `echo ssh ec2-user@$(aws --region us-west-1 ec2 describe-instances --filters  "Name=tag:Name,Values=VulnadoReverseShellReceiver" | jq -r '.Reservations[0].Instances[0]|.PublicIpAddress')`: Este comando imprime um comando SSH que pode ser usado para se conectar à instância EC2 que foi criada.
   - `aws --region us-west-1 ec2 describe-instances --filters  "Name=tag:Name,Values=VulnadoReverseShellReceiver"`: Este comando da AWS CLI lista todas as instâncias EC2 na região `us-west-1` que têm uma tag `Name` com o valor `VulnadoReverseShellReceiver`.
   - `jq -r '.Reservations[0].Instances[0]|.PublicIpAddress'`: Este comando usa a ferramenta `jq` para extrair o endereço IP público da primeira instância EC2 retornada pelo comando AWS CLI.
```
