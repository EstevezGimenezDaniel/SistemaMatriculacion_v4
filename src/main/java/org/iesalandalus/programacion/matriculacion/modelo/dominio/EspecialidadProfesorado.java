package org.iesalandalus.programacion.matriculacion.modelo.dominio;

import java.util.Objects;

public enum EspecialidadProfesorado {
    INFORMATICA("Informática"),
    SISTEMAS("Sistemas"),
    FOL("Fol");
    private String cadenaAMostrar;
    private EspecialidadProfesorado(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    public String imprimir() {
        int digito = 0;
        if (Objects.equals(cadenaAMostrar, INFORMATICA.cadenaAMostrar)) {
            digito = 0;
        } else if (Objects.equals(cadenaAMostrar, SISTEMAS.cadenaAMostrar)) {
            digito = 1;
        } else {
            digito = 2;
        }
        return digito + ".-" + cadenaAMostrar;
    }

    @Override
    public String toString() {
        return "La especialidad seleccionada:" + cadenaAMostrar;
    }
}
