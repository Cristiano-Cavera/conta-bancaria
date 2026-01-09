package com.cristiano.banco.service;

import com.cristiano.banco.model.ContaBancaria;

public class ContaService {

    public void consultarSaldo(ContaBancaria conta) {
        System.out.println("Saldo atual: R$ " + conta.getSaldo());
    }

    public void consultarChequeEspecial(ContaBancaria conta) {
        System.out.println("Limite do cheque especial: R$ " + conta.getLimiteChequeEspecial());
        System.out.println("Valor usado do cheque especial: R$ " + conta.getValorUsadoChequeEspecial());

        if (conta.usandoChequeEspecial()) {
            System.out.println("⚠ Atenção: Você está utilizando o cheque especial!");
        } else {
            System.out.println("✅ Você não está utilizando o cheque especial.");
        }
    }

    public void depositar(ContaBancaria conta, double valor) {
        conta.depositar(valor);
    }

    public void sacar(ContaBancaria conta, double valor) {
        if (!conta.sacar(valor)) {
            System.out.println("Saldo insuficiente para saque!");
        }
    }

    public void pagarBoleto(ContaBancaria conta, double valor) {
        if (!conta.pagarBoleto(valor)) {
            System.out.println("Saldo insuficiente para pagamento do boleto!");
        }
    }
}