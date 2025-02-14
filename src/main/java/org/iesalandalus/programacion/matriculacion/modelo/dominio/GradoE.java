package org.iesalandalus.programacion.matriculacion.modelo.dominio;

import javax.xml.parsers.SAXParser;

public class GradoE extends Grado {
    private int numEdiciones;

    public GradoE(String nombre, int numAnios, int numEdiciones) {
        super(nombre);
        setNumAnios(numAnios);
        setNumEdiciones(numEdiciones);
    }

    public int getNumEdiciones() {
        return numEdiciones;
    }

    public void setNumEdiciones(int numEdiciones) {
        if (numEdiciones<1) {
            throw new IllegalArgumentException("ERROR: El numero de ediciones de un Grado E no puede ser menor a 1");
        }
        this.numEdiciones=numEdiciones;

    }

    @Override
    public void setNumAnios(int numAnios) {
        if (numAnios!=1) {
            throw new  IllegalArgumentException("ERROR: El numero de años de un Grado E debe ser 1");
        }
        this.numAnios=numAnios;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + numEdiciones + " ediciones";
    }

}
