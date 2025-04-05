package org.iesalandalus.programacion.matriculacion.modelo.negocio.memoria;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.Asignatura;
import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;

public class Asignaturas {
    private ArrayList<Asignatura> coleccionAsignaturas;

    public Asignaturas() {
        coleccionAsignaturas = new ArrayList<>();
    }

    public ArrayList<Asignatura> get() {

        return copiaProfundaAsignaturas();
    }

    private ArrayList<Asignatura> copiaProfundaAsignaturas() {
        ArrayList<Asignatura> copiaAsignaturas = new ArrayList<>();
        for (Asignatura a : coleccionAsignaturas) {
            copiaAsignaturas.add(new Asignatura(a));
        }
        return copiaAsignaturas;
    }

    public int getTamano() {
        return this.coleccionAsignaturas.size();
    }

    public void insertar(Asignatura asignatura) throws OperationNotSupportedException {
        if (asignatura==null) {
            throw new NullPointerException("ERROR: No se puede insertar una asignatura nula.");
        }

        int indice = this.coleccionAsignaturas.indexOf(asignatura);
        if (indice == -1) {
            coleccionAsignaturas.add(new Asignatura(asignatura));
        } else {
            throw new OperationNotSupportedException("ERROR: Ya existe una asignatura con ese código.");
        }
    }


    public Asignatura buscar(Asignatura asignatura) {
        if (asignatura==null) {
            throw new NullPointerException("ERROR: No se puede buscar una asignatura nula.");
        }
        int indice = this.coleccionAsignaturas.indexOf(asignatura);
        if (indice == -1) {
            return null;
        } else {
            return this.coleccionAsignaturas.get(indice);
        }
    }

    public void borrar(Asignatura asignatura) throws OperationNotSupportedException {
        if (asignatura==null) {
            throw new NullPointerException("ERROR: No se puede borrar una asignatura nula.");
        }

        int indice = this.coleccionAsignaturas.indexOf(asignatura);
        if (indice == -1) {
            throw new OperationNotSupportedException("ERROR: No existe ninguna asignatura como la indicada.");
        }
        this.coleccionAsignaturas.remove(indice);
    }
}