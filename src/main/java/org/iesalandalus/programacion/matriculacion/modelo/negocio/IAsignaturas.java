package org.iesalandalus.programacion.matriculacion.modelo.negocio;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.Asignatura;

import javax.naming.OperationNotSupportedException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IAsignaturas {

    public void comenzar();

    public void terminar();

    public ArrayList<Asignatura> get() throws SQLException;

    public int getTamano() throws SQLException;

    public void insertar(Asignatura asignatura) throws OperationNotSupportedException, SQLException;

    public Asignatura buscar(Asignatura asignatura) throws SQLException;

    public void borrar(Asignatura asignatura) throws OperationNotSupportedException, SQLException;

}