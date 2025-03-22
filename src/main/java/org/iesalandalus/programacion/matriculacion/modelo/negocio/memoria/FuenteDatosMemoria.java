package org.iesalandalus.programacion.matriculacion.modelo.negocio.memoria;

import org.iesalandalus.programacion.matriculacion.modelo.negocio.*;
import org.iesalandalus.programacion.matriculacion.modelo.negocio.mysql.Alumnos;
import org.iesalandalus.programacion.matriculacion.modelo.negocio.mysql.Asignaturas;
import org.iesalandalus.programacion.matriculacion.modelo.negocio.mysql.CiclosFormativos;
import org.iesalandalus.programacion.matriculacion.modelo.negocio.mysql.Matriculas;

public class FuenteDatosMemoria implements IFuenteDatos {

    @Override
    public IAlumnos crearAlumnos() {
        return new Alumnos();
    }

    @Override
    public ICiclosFormativos crearCiclosFormativos() {
        return new CiclosFormativos();
    }

    @Override
    public IAsignaturas crearAsignaturas() {
        return new Asignaturas();
    }

    @Override
    public IMatriculas crearMatriculas() {
        return new Matriculas();
    }

}