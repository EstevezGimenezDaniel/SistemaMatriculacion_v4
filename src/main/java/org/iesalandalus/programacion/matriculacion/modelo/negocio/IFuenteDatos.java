package org.iesalandalus.programacion.matriculacion.modelo.negocio;

public interface IFuenteDatos {

    public IAlumnos crearAlumnos();

    public ICiclosFormativos crearCiclosFormativos();

    public IAsignaturas crearAsignaturas();

    public IMatriculas crearMatriculas();

}
