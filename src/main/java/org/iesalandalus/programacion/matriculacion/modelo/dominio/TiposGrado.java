package org.iesalandalus.programacion.matriculacion.modelo.dominio;

public enum TiposGrado {
    GRADOD("Grado D"),
    GRADOE("Grado E");
    private String cadenaAMostrar;

    private TiposGrado(String cadenaAMostrar) {
        this.cadenaAMostrar=cadenaAMostrar;
    }
    public String imprimir() {
        int digito=0;
        if (cadenaAMostrar==GRADOD.cadenaAMostrar) {
            digito=0;
        }
        else if (cadenaAMostrar==GRADOE.cadenaAMostrar) {
            digito=1;
        }
        else {
            digito=2;
        }
        return digito + ".-" + cadenaAMostrar;
    }

    @Override
    public String toString() {
        return "Grado seleccionado:" +
                "cadenaAMostrar='" + cadenaAMostrar + '\'' +
                '}';
    }
}
