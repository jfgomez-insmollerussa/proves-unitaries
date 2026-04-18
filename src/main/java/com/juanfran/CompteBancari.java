package com.juanfran;

public class CompteBancari {

    private final String titular;
    private final String iban;
    private double saldo;

    public CompteBancari(String titular, String iban, double saldo) {
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("El titular és obligatori");
        }
        if (iban == null || iban.trim().isEmpty()) {
            throw new IllegalArgumentException("L'IBAN és obligatori");
        }
        if (saldo < 0) {
            throw new IllegalArgumentException("El saldo inicial no pot ser negatiu");
        }

        this.titular = titular;
        this.iban = iban;
        this.saldo = saldo;
    }

    public void ingressar(double quantitat) {
        if (quantitat <= 0) {
            throw new IllegalArgumentException("La quantitat ha de ser positiva");
        }

        saldo += quantitat;
    }

    public void retirar(double quantitat) {
        if (quantitat <= 0) {
            throw new IllegalArgumentException("La quantitat ha de ser positiva");
        }
        if (quantitat > saldo) {
            throw new IllegalArgumentException("No hi ha prou saldo");
        }

        saldo -= quantitat;
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
