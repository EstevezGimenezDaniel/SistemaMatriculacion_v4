package org.iesalandalus.programacion.matriculacion;

import org.iesalandalus.programacion.matriculacion.controlador.Controlador;
import org.iesalandalus.programacion.matriculacion.modelo.FactoriaFuenteDatos;
import org.iesalandalus.programacion.matriculacion.modelo.Modelo;
import org.iesalandalus.programacion.matriculacion.vista.Vista;

public class MainApp {

    public static void main(String[] args) {

        args = new String[] {"-fdmysql"};

        Modelo modelo = procesarArgumentosFuenteDatos(args[0]);

        Vista vista = new Vista();

        Controlador controlador = new Controlador(modelo, vista);

        controlador.comenzar();

        controlador.terminar();
    }

    private static Modelo procesarArgumentosFuenteDatos(String in_args) {
        if (in_args.equalsIgnoreCase("-fdmemoria")) {
            return new Modelo(FactoriaFuenteDatos.MEMORIA);
        }else if (in_args.equalsIgnoreCase("-fdmysql")) {
            return new Modelo(FactoriaFuenteDatos.MYSQL);
        }else {
            return null;
        }
    }
}
