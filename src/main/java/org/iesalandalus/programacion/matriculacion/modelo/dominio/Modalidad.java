package org.iesalandalus.programacion.matriculacion.modelo.dominio;

public enum Modalidad {
    PRESENCIAL("Presencial"),
    SEMIPRESENCIAL("Semipresencial");
    private String cadenaAMostrar;

    private Modalidad(String cadenaAMostrar) {
        this.cadenaAMostrar=cadenaAMostrar;
    }

    public String imprimir() {
        int digito = 0;
        if (cadenaAMostrar == PRESENCIAL.cadenaAMostrar) {
            digito = 0;
        } else if (cadenaAMostrar == SEMIPRESENCIAL.cadenaAMostrar) {
            digito = 1;
        } else {
            digito = 2;
        }
        return digito + ".-" + cadenaAMostrar;
    }

    public String toString() {
        return cadenaAMostrar;
    }
}
