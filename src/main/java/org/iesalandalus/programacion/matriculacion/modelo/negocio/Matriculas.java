package org.iesalandalus.programacion.matriculacion.modelo.negocio;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Asignatura;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.CicloFormativo;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Matricula;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Objects;

public class Matriculas {
    private ArrayList<Matricula> coleccionMatriculas;

    public Matriculas() {
        coleccionMatriculas = new ArrayList<>();
    }

    public ArrayList<Matricula> get() throws OperationNotSupportedException {
        return copiaProfundaMatriculas();
    }

    private ArrayList<Matricula> copiaProfundaMatriculas() throws OperationNotSupportedException {
        ArrayList<Matricula> copiaMatriculas = new ArrayList<>();
        for (Matricula m : coleccionMatriculas) {
            copiaMatriculas.add(new Matricula(m));
        }
        return copiaMatriculas;
    }

    public int getTamano() {
        return this.coleccionMatriculas.size();
    }

    public void insertar(Matricula matricula) throws OperationNotSupportedException {
        if (matricula==null) {
            throw new NullPointerException("ERROR: No se puede insertar una matrícula nula.");
        }

        int indice = this.coleccionMatriculas.indexOf(matricula);

        if (indice == -1) {
            coleccionMatriculas.add(new Matricula(matricula));
        } else {
            throw new OperationNotSupportedException("ERROR: Ya existe una matrícula con ese identificador.");
        }
    }

    public Matricula buscar(Matricula matricula) throws OperationNotSupportedException {
        if (matricula==null) {
            throw new NullPointerException("ERROR: No se puede buscar una Matricula nula.");
        }

        int indice = this.coleccionMatriculas.indexOf(matricula);
        if (indice == -1) {
            return null;
        } else {
            return new Matricula(this.coleccionMatriculas.get(indice));
        }
    }

    public void borrar(Matricula matricula) throws OperationNotSupportedException {
        if (matricula==null) {
            throw new NullPointerException("ERROR: No se puede borrar una Matricula nula.");
        }
        int indice = this.coleccionMatriculas.indexOf(matricula);
        if (indice != -1) {
            throw new OperationNotSupportedException("ERROR: No existe ninguna matrícula como la indicada.");
        }
        coleccionMatriculas.remove(indice);
    }

    public ArrayList<Matricula> get(Alumno alumno) throws OperationNotSupportedException {
        ArrayList<Matricula> aux = new ArrayList<>();
        for (Matricula matricula : coleccionMatriculas) {
            if (matricula != null && matricula.getAlumno().equals(alumno)) {
                aux.add(new Matricula(matricula));
            }
        }
        return aux;
    }

    public ArrayList<Matricula> get(String cursoAcademico) throws OperationNotSupportedException {
        ArrayList<Matricula> aux = new ArrayList<>();
        for (Matricula matricula : coleccionMatriculas) {
            if (matricula != null && matricula.getCursoAcademico().equals(cursoAcademico)) {
                aux.add(new Matricula(matricula));
            }
        }
        return aux;
    }

    public ArrayList<Matricula> get(CicloFormativo cicloFormativo) throws OperationNotSupportedException {
        ArrayList<Matricula> aux = new ArrayList<>();
        for (Matricula matricula : coleccionMatriculas) {
            if (matricula != null) {
                for (Asignatura asignatura : matricula.getColeccionAsignaturas()) {
                    if (asignatura != null && asignatura.getCicloFormativo().equals(cicloFormativo)) {
                        aux.add(new Matricula(matricula));
                        break;
                    }
                }
            }
        }
        return aux;
    }
}