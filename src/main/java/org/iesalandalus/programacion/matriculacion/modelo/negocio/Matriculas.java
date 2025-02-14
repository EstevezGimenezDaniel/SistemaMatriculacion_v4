package org.iesalandalus.programacion.matriculacion.modelo.negocio;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Asignatura;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.CicloFormativo;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Matricula;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Matriculas {
    private int capacidad;
    private int tamano;
    private Matricula[] coleccionMatriculas;

    public Matriculas(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
        }
        this.capacidad = capacidad;
        this.tamano = 0;
        this.coleccionMatriculas = new Matricula[capacidad];
    }

    public Matricula[] get() throws OperationNotSupportedException {
        return copiaProfundaMatriculas();
    }

    private Matricula[] copiaProfundaMatriculas(){
        Matricula[] copia = new Matricula[tamano];
        for (int i = 0; i < tamano; i++) {
            copia[i] = new Matricula(coleccionMatriculas[i]);
        }
        return copia;
    }

    public int getTamano() {
        return tamano;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void insertar(Matricula matricula) throws OperationNotSupportedException {
        if (matricula == null) {
            throw new NullPointerException("ERROR: No se puede insertar una matr?cula nula.");
        }
        if (tamano >= coleccionMatriculas.length) {
            throw new OperationNotSupportedException("ERROR: No se aceptan m?s matr?culas.");
        }
        if (buscar(matricula) != null) {
            throw new OperationNotSupportedException("ERROR: Ya existe una matr?cula con ese identificador.");
        }
        coleccionMatriculas[tamano] = new Matricula(matricula);
        tamano++;
    }
    public Matricula buscar(Matricula matricula){
        for (int i = 0; i < tamano; i++) {
            if (Objects.equals(coleccionMatriculas[i], matricula)) {
                return coleccionMatriculas[i];
            }
        }
        return null;
    }

    public void borrar(Matricula matricula) throws OperationNotSupportedException{
        int indice = buscarIndice(matricula);
        if(matricula==null) {
            throw new NullPointerException("ERROR: No se puede borrar una matr?cula nula.");
        }
        if (indice == -1) {
            throw new OperationNotSupportedException("ERROR: No existe ninguna matr?cula como la indicada.");
        }
        desplazarUnaPosicionHaciaIzquierda(indice);
        tamano--;
    }

    private int buscarIndice(Matricula matricula) {
        for (int i = 0; i < tamano; i++) {
            if (Objects.equals(coleccionMatriculas[i], matricula)) {
                return i;
            }
        }
        return -1;
    }

    private void desplazarUnaPosicionHaciaIzquierda(int indice) {
        for (int i = indice; i < tamano - 1; i++) {
            coleccionMatriculas[i] = coleccionMatriculas[i + 1];
        }
        coleccionMatriculas[tamano - 1] = null;
    }

    private boolean capacidadSuperada(int indice) {

        return indice >= capacidad;
    }

    public Matricula[] get(Alumno alumno) {
        Matricula[] resultado = new Matricula[tamano];
        int contador = 0;
        for (int i = 0; i < tamano; i++) {
            if (coleccionMatriculas[i].getAlumno().equals(alumno)) {
                resultado[contador++] = coleccionMatriculas[i];
            }
        }
        return ajustarTamano(resultado, contador);
    }

    public Matricula[] get(String cursoAcademico){
        Matricula[] resultado = new Matricula[tamano];
        int contador = 0;
        for (int i = 0; i < tamano; i++) {
            if (coleccionMatriculas[i].getCursoAcademico().equals(cursoAcademico)) {
                resultado[contador++] = coleccionMatriculas[i];
            }
        }
        return ajustarTamano(resultado, contador);
    }

    public Matricula[] get(CicloFormativo cicloFormativo){
        if (cicloFormativo == null) {
            throw new NullPointerException("ERROR: El ciclo formativo no puede ser nulo.");
        }

        Matricula[] resultado = new Matricula[tamano];
        int contador = 0;

        for (int i = 0; i < tamano; i++) {
            Asignatura[] asignaturas = coleccionMatriculas[i].getColeccionAsignaturas();
            for (Asignatura asignatura : asignaturas) {
                if (asignatura.getCicloFormativo().equals(cicloFormativo)) {
                    resultado[contador++] = new Matricula(coleccionMatriculas[i]);
                    break;
                }
            }
        }
        return ajustarTamano(resultado, contador);
    }



    private Matricula[] ajustarTamano(Matricula[] arreglo, int nuevoTamano) {
        Matricula[] ajustado = new Matricula[nuevoTamano];
        System.arraycopy(arreglo, 0, ajustado, 0, nuevoTamano);
        return ajustado;
    }
}
