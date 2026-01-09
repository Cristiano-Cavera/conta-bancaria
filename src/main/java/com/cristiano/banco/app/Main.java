package com.cristiano.banco.app;

import java.util.Scanner;
import com.cristiano.banco.model.ContaBancaria;
import com.cristiano.banco.service.ContaService;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Bem-vindo ao Banco ===");

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Digite o valor inicial para abrir a conta: ");
            double depositoInicial = sc.nextDouble();

            ContaBancaria conta = new ContaBancaria(depositoInicial);
            ContaService service = new ContaService();

            int opcao;
            do {
                System.out.println("\n=== Menu Conta Bancária ===");
                System.out.println("1 - Consultar saldo");
                System.out.println("2 - Consultar cheque especial");
                System.out.println("3 - Depositar");
                System.out.println("4 - Sacar");
                System.out.println("5 - Pagar boleto");
                System.out.println("6 - Verificar uso do cheque especial");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                opcao = sc.nextInt();

                switch (opcao) {
                    case 1 -> service.consultarSaldo(conta);
                    case 2 -> service.consultarChequeEspecial(conta);
                    case 3 -> {
                        System.out.print("Valor do depósito: ");
                        double valor = sc.nextDouble();
                        service.depositar(conta, valor);
                    }
                    case 4 -> {
                        System.out.print("Valor do saque: ");
                        double valor = sc.nextDouble();
                        service.sacar(conta, valor);
                    }
                    case 5 -> {
                        System.out.print("Valor do boleto: ");
                        double valor = sc.nextDouble();
                        service.pagarBoleto(conta, valor);
                    }
                    case 6 -> {
                        if (conta.usandoChequeEspecial()) {
                            System.out.println("⚠ Atenção: Você está utilizando o cheque especial!");
                        } else {
                            System.out.println("✅ Você não está utilizando o cheque especial.");
                        }
                    }
                    case 0 -> System.out.println("Encerrando...");
                    default -> System.out.println("Opção inválida!");
                }
            } while (opcao != 0);
        }
    }
}