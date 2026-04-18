# Proves Unitaries

Proyecto Java con Maven para practicar pruebas unitarias sobre una clase de cuenta bancaria.

## Tecnologias

- Java 17
- Maven Wrapper
- JUnit 5

## Estructura

- `src/main/java/com/juanfran/CompteBancari.java`: implementacion de la cuenta bancaria
- `src/test/java/com/juanfran/CompteBancariTest.java`: pruebas unitarias

## Ejecutar tests

En la raiz del proyecto:

```bash
./mvnw test
```

En Windows PowerShell:

```powershell
.\mvnw.cmd test
```

## Objetivo

El proyecto valida operaciones basicas como:

- creacion de cuentas
- ingresos
- retiradas
- control de errores en casos invalidos
