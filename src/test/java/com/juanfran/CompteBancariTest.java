package com.juanfran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CompteBancariTest {

    private CompteBancari compte;

    @BeforeEach
    void setUp() {
        compte = new CompteBancari("Joan Garcia", "ES7620770024003102575766", 1000.0);
    }

    @Test
    void creacioCorrecta() {
        CompteBancari novaCompte = new CompteBancari("Anna Serra", "ES9121000418450200051332", 500.0);

        assertEquals("Anna Serra", novaCompte.getTitular());
        assertEquals("ES9121000418450200051332", novaCompte.getIban());
        assertEquals(500.0, novaCompte.getSaldo());
    }

    @Test
    void errorTitularBuit() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new CompteBancari("", "ES9121000418450200051332", 500.0));

        assertEquals("El titular és obligatori", exception.getMessage());
    }

    @Test
    void errorIbanBuit() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new CompteBancari("Anna Serra", "", 500.0));

        assertEquals("L'IBAN és obligatori", exception.getMessage());
    }

    @Test
    void errorSaldoInicialNegatiu() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new CompteBancari("Anna Serra", "ES9121000418450200051332", -100.0));

        assertEquals("El saldo inicial no pot ser negatiu", exception.getMessage());
    }

    @Test
    void ingresCorrecte() {
        compte.ingressar(200.0);

        assertEquals(1200.0, compte.getSaldo());
    }

    @Test
    void retiradaCorrecta() {
        compte.retirar(300.0);

        assertEquals(700.0, compte.getSaldo());
    }

    @Test
    void errorRetirarMesSaldoDisponible() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> compte.retirar(1500.0));

        assertEquals("No hi ha prou saldo", exception.getMessage());
    }

    @Test
    void errorIngressarQuantitatNoPositiva() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> compte.ingressar(0.0));

        assertEquals("La quantitat ha de ser positiva", exception.getMessage());
    }

    @Test
    void errorRetirarQuantitatNoPositiva() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> compte.retirar(-50.0));

        assertEquals("La quantitat ha de ser positiva", exception.getMessage());
    }

    @Test
    void estatSaldoCorrecte() {
        assertEquals("Saldo normal", compte.getEstatSaldo());

        compte.retirar(200.0);
        assertEquals("Saldo baix", compte.getEstatSaldo());

        compte.ingressar(5000.0);
        assertEquals("Saldo alt", compte.getEstatSaldo());
    }
}
