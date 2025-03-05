package org.iesalandalus.programacion.matriculacion.modelo.negocio;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.Alumno;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Objects;

public class Alumnos {
    private ArrayList<Alumno> coleccionAlumnos;

    public Alumnos() {
        coleccionAlumnos = new ArrayList<>();
    }

    public ArrayList<Alumno> get() {
        return copiaProfundaAlumnos();
    }

    private ArrayList<Alumno> copiaProfundaAlumnos() {
        ArrayList<Alumno> copiaAlumnos = new ArrayList<>();
        for (Alumno a : coleccionAlumnos) {
            copiaAlumnos.add(new Alumno(a));
        }
        return copiaAlumnos;
    }

    public int getTamano() {
        return this.coleccionAlumnos.size();
    }

    public void insertar(Alumno alumno) throws OperationNotSupportedException {
        if (alumno == null) {
            throw new NullPointerException("ERROR: No se puede insertar un alumno nulo.");
        }

        int indice = this.coleccionAlumnos.indexOf(alumno);
        if (indice == -1) {
            this.coleccionAlumnos.add(new Alumno(alumno));
        } else {
            throw new OperationNotSupportedException("ERROR: Ya existe un alumno con ese dni.");
        }
    }

    public Alumno buscar(Alumno alumno) {
        if (alumno==null) {
            throw new NullPointerException("ERROR: No se puede buscar un alumno nulo.");
        }

        int indice = this.coleccionAlumnos.indexOf(alumno);
        if (indice == -1) {
            return null;
        } else {
            return this.coleccionAlumnos.get(indice);
        }
    }

    public void borrar(Alumno alumno) throws OperationNotSupportedException {
        if (alumno==null) {
            throw new NullPointerException("ERROR: No se puede borrar un alumno nulo.");
        }
        int indice = this.coleccionAlumnos.indexOf(alumno);
        if (indice == -1) {
            throw new OperationNotSupportedException("ERROR: No existe ningún alumno como el indicado.");
        }
        this.coleccionAlumnos.remove(indice);
    }
}