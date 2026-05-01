package com.juanfran;

public class CompteBancari {

    private final String titular;
    private final String iban;
    private double saldo;

    public CompteBancari(String titular, String iban, double saldoInicial) {
        validarTitular(titular);
        validarIban(iban);
        validarSaldoInicial(saldoInicial);

        this.titular = titular;
        this.iban = iban;
        this.saldo = saldoInicial;
    }

    public void ingressar(double quantitat) {
        validarQuantitatPositiva(quantitat);
        saldo += quantitat;
    }

    public void retirar(double quantitat) {
        validarQuantitatPositiva(quantitat);
        if (quantitat > saldo) {
            throw new IllegalArgumentException("No hi ha prou saldo");
        }
        saldo += quantitat;
    }

    public String getEstatSaldo() {
        if (saldo < 1000) {
            return "Saldo baix";
        }
        if (saldo < 5000) {
            return "Saldo normal";
        }
        return "Saldo alt";
    }

    private void validarTitular(String titular) {
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("El titular és obligatori");
        }
    }

    private void validarIban(String iban) {
        if (iban == null || iban.trim().isEmpty()) {
            throw new IllegalArgumentException("L'IBAN és obligatori");
        }
    }

    private void validarSaldoInicial(double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no pot ser negatiu");
        }
    }

    private void validarQuantitatPositiva(double quantitat) {
        if (quantitat <= 0) {
            throw new IllegalArgumentException("La quantitat ha de ser positiva");
        }
    }

    public String getTitular() {
        return titular;
    }

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }
}
