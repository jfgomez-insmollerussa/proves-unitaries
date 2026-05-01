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
    }

    @Test
    void errorTitularBuit() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new CompteBancari("", "ES9121000418450200051332", 500.0));

        assertEquals("Error titular", exception.getMessage());
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

        assertEquals("Error", exception.getMessage());
    }
}
