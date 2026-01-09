package com.cristiano.banco.model;

public class ContaBancaria {
    private double saldo;
    private final double limiteChequeEspecial;
    private double valorUsadoChequeEspecial = 0.0;

    // Construtor
    public ContaBancaria(double depositoInicial) {
        this.saldo = depositoInicial;
        if (depositoInicial <= 500) {
            this.limiteChequeEspecial = 50.0;
        } else {
            this.limiteChequeEspecial = depositoInicial * 0.5;
        }
    }

    // Métodos principais
    public void depositar(double valor) {
        if (valor > 0) {
            if (valorUsadoChequeEspecial > 0) {
                // Primeiro cobre o cheque especial usado + taxa de 20%
                double taxa = valorUsadoChequeEspecial * 0.2;
                double totalDevido = valorUsadoChequeEspecial + taxa;

                if (valor >= totalDevido) {
                    valor -= totalDevido;
                    System.out.println("Cheque especial quitado com taxa de R$ " + taxa);
                    valorUsadoChequeEspecial = 0;
                } else {
                    // Parte do depósito cobre cheque especial
                    double quitado = valor / 1.2;
                    valorUsadoChequeEspecial -= quitado;
                    System.out.println("Parte do depósito usada para reduzir cheque especial.");
                    return;
                }
            }
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
            return true;
        } else if (valor <= saldo + (limiteChequeEspecial - valorUsadoChequeEspecial)) {
            double restante = valor - saldo;
            saldo = 0;
            valorUsadoChequeEspecial += restante;
            System.out.println("Saque de R$ " + valor + " realizado usando cheque especial!");
            return true;
        } else {
            return false;
        }
    }

    public boolean pagarBoleto(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Boleto de R$ " + valor + " pago com sucesso!");
            return true;
        } else if (valor <= saldo + (limiteChequeEspecial - valorUsadoChequeEspecial)) {
            double restante = valor - saldo;
            saldo = 0;
            valorUsadoChequeEspecial += restante;
            System.out.println("Boleto de R$ " + valor + " pago usando cheque especial!");
            return true;
        } else {
            return false;
        }
    }

    // Métodos auxiliares
    public double getSaldo() {
        return saldo;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public double getValorUsadoChequeEspecial() {
        return valorUsadoChequeEspecial;
    }

    public boolean usandoChequeEspecial() {
        return valorUsadoChequeEspecial > 0;
    }
}