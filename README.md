# 💳 Conta Bancária

## 📌 Enunciado da questão

Todos os exercícios devem ter um **menu interativo** para chamar as funções e uma opção de **sair** para finalizar a execução.

Escreva um código onde temos uma **conta bancária** que possa realizar as seguintes operações:
- Consultar saldo
- Consultar cheque especial
- Depositar dinheiro
- Sacar dinheiro
- Pagar um boleto
- Verificar se a conta está usando cheque especial

### Regras de implementação
- A conta bancária deve ter um **limite de cheque especial** somado ao saldo da conta.
- O valor do cheque especial é definido no momento da criação da conta, de acordo com o valor depositado:
  - Se o valor depositado na criação da conta for **R$ 500,00 ou menos**, o cheque especial deve ser de **R$ 50,00**.
  - Para valores **acima de R$ 500,00**, o cheque especial deve ser de **50% do valor depositado**.
- Caso o limite de cheque especial seja usado, assim que possível a conta deve cobrar uma **taxa de 20%** do valor utilizado do cheque especial.

## 🧪 Exemplo de execução

### Cenário: usuário devendo R$ 50 do cheque especial e depositando R$ 100

- Situação inicial:
  - Saldo: R$ 0
  - Uso do cheque especial: R$ 50

- Ação: depósito de R$ 100

- Resultado:
  - R$ 60 usados para quitar cheque especial (R$ 50 + taxa de R$ 10)
  - R$ 40 adicionados ao saldo
  - Uso do cheque especial: R$ 0

---

## 🚀 Como executar

### Requisitos
- JDK 17 ou superior
- Maven instalado

### Passos
1. Clone o repositório:
   ```bash
   git clone https://github.com/Cristiano-Cavera/conta-bancaria.git
   cd conta-bancaria
   mvn clean compile exec:java -Dexec.mainClass="com.cristiano.banco.app.Main"
