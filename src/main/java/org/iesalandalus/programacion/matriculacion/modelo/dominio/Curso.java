package org.iesalandalus.programacion.matriculacion.modelo.dominio;

import java.util.Objects;

public enum Curso {
    PRIMERO("Primero"),
    SEGUNDO("Segundo");
    private String cadenaAMostrar;

    private Curso(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;

    }

    public String imprimir() {
        int digito = 0;
        if (Objects.equals(cadenaAMostrar, PRIMERO.cadenaAMostrar)) {
            digito = 0;
        } else {
            digito = 1;
        }
        return digito + ".-" + cadenaAMostrar;
    }

    @Override
    public String toString() {
        return "Curso seleccionado:" + cadenaAMostrar;
    }
}
