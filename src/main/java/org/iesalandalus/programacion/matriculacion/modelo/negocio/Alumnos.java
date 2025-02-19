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
        for (int i = 0; i < this.coleccionAlumnos.size(); i++) {
            copiaAlumnos.add(new Alumno(coleccionAlumnos.get(i)));
        }
        return copiaAlumnos;
    }

    public int getTamano() {
        return this.coleccionAlumnos.size();
    }

    public void insertar(Alumno alumno) throws OperationNotSupportedException {
        Objects.requireNonNull(alumno, "ERROR: No se puede insertar un alumno nulo.");

        int indice = this.coleccionAlumnos.indexOf(alumno);
        if (indice != -1) {
            throw new OperationNotSupportedException("ERROR: Ya existe un alumno con ese dni.");
        }
        this.coleccionAlumnos.add(new Alumno(alumno));
    }

    public Alumno buscar(Alumno alumno) {
        Objects.requireNonNull(alumno, "ERROR: 2.No se puede buscar un alumno nulo.");
        int indice = this.coleccionAlumnos.indexOf(alumno);
        if (indice == -1) {
            return null;
        } else {
            return new Alumno(this.coleccionAlumnos.get(indice));
        }
    }

    public void borrar(Alumno alumno) throws OperationNotSupportedException {
        Objects.requireNonNull(alumno, "ERROR: No se puede borrar un alumno nulo.");
        int indice = this.coleccionAlumnos.indexOf(alumno);
        if (indice==-1) {
            throw new OperationNotSupportedException("ERROR: No existe ningún alumno como el indicado.");
        }
        this.coleccionAlumnos.remove(indice);
    }

}