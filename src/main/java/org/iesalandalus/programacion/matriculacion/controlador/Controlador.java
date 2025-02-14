package org.iesalandalus.programacion.matriculacion.controlador;

import org.iesalandalus.programacion.matriculacion.modelo.Modelo;
import org.iesalandalus.programacion.matriculacion.vista.Vista;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.*;

import javax.naming.OperationNotSupportedException;

public class Controlador {
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        if (modelo == null || vista == null) {
            throw new IllegalArgumentException("El modelo y la vista no pueden ser nulos.");
        }
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControlador(this);
    }

    public void comenzar() {
        modelo.comenzar();
        vista.comenzar();
    }

    public void terminar() {
        modelo.terminar();
        vista.terminar();
    }

    public void insertar(Alumno alumno) throws OperationNotSupportedException {
        modelo.insertar(alumno);
    }

    public Alumno buscar(Alumno alumno) {
        return modelo.buscar(alumno);
    }

    public void borrar(Alumno alumno) throws OperationNotSupportedException {
        modelo.borrar(alumno);
    }

    public Alumno[] getAlumnos() {
        return modelo.getAlumnos();
    }

    public void insertar(Asignatura asignatura) throws OperationNotSupportedException {
        modelo.insertar(asignatura);
    }

    public Asignatura buscar(Asignatura asignatura) {
        return modelo.buscar(asignatura);
    }

    public void borrar(Asignatura asignatura) throws OperationNotSupportedException {
        modelo.borrar(asignatura);
    }

    public Asignatura[] getAsignaturas() {
        return modelo.getAsignaturas();
    }

    public void insertar(CicloFormativo cicloFormativo) throws OperationNotSupportedException {
        modelo.insertar(cicloFormativo);
    }

    public CicloFormativo buscar(CicloFormativo cicloFormativo) {
        return modelo.buscar(cicloFormativo);
    }

    public void borrar(CicloFormativo cicloFormativo) throws OperationNotSupportedException {
        modelo.borrar(cicloFormativo);
    }

    public CicloFormativo[] getCiclosFormativos() {
        return modelo.getCiclosFormativos();
    }

    public void insertar(Matricula matricula) throws OperationNotSupportedException {
        modelo.insertar(matricula);
    }

    public Matricula buscar(Matricula matricula) throws OperationNotSupportedException {
        return modelo.buscar(matricula);
    }

    public void borrar(Matricula matricula) throws OperationNotSupportedException {
        modelo.borrar(matricula);
    }

    public Matricula[] getMatriculas() throws OperationNotSupportedException {
        return modelo.getMatriculas();
    }

    public Matricula[] getMatriculas(Alumno alumno) throws OperationNotSupportedException {
        return modelo.getMatriculas(alumno);
    }

    public Matricula[] getMatriculas(CicloFormativo cicloFormativo) {
        return modelo.getMatriculas(cicloFormativo);
    }

    public Matricula[] getMatriculas(String cursoAcademico) {
        return modelo.getMatriculas(cursoAcademico);
    }

    public CicloFormativo[] getCicloFormativos() {
        return modelo.getCiclosFormativos();
    }
}
