package org.iesalandalus.programacion.matriculacion.modelo.negocio.mysql.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
    private static final String HOST = "daw-2425.c3ycmcqi09v2.us-east-1.rds.amazonaws.com";
    private static final String ESQUEMA = "dbsistemamatriculacion";
    private static final String USUARIO = "admin";
    private static final String CONTRASENA = "sistemamatriculacion-2025";

    private static Connection conexion;

    private MySQL() {
    }

    public static Connection establecerConexion() {
        if (conexion == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                String url = "jdbc:mysql://" + HOST + ":3306/" + ESQUEMA;

                conexion = DriverManager.getConnection(url, USUARIO, CONTRASENA);
                System.out.println("Conexión establecida con éxito.");
            } catch (ClassNotFoundException e) {
                System.out.println("Error: No se encontró el driver de MySQL.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Error al conectar a la base de datos.");
                e.printStackTrace();
            }
        }
        return conexion;
    }

    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                conexion = null;
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión.");
                e.printStackTrace();
            }
        }
    }
}
