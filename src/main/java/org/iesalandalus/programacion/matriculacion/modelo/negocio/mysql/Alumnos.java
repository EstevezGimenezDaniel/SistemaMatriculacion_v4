package org.iesalandalus.programacion.matriculacion.modelo.negocio.mysql;

import java.sql.*;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.modelo.negocio.IAlumnos;
import org.iesalandalus.programacion.matriculacion.modelo.negocio.mysql.utilidades.MySQL;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;

public class Alumnos implements IAlumnos {

    private Connection conexion;

    private static Alumnos instancia = null;

    private ArrayList<Alumno> coleccionAlumnos;

    public Alumnos() {
        this.coleccionAlumnos = new ArrayList<>();
        comenzar();
    }

    public static Alumnos getInstancia() {
        if(instancia == null) {
            instancia = new Alumnos();
        }
        return instancia;
    }

    public ArrayList<Alumno> get() throws SQLException {
        ArrayList<Alumno> copiaAlumnos = new ArrayList<>();
        String query = """
    			SELECT nombre
    				, dni
    				, correo
    				, telefono
    				, fechaNacimiento 
    			FROM alumno
    			ORDER BY dni
    			""";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            Alumno alumno = new Alumno(
                    rs.getString("nombre"),
                    rs.getString("dni"),
                    rs.getString("correo"),
                    rs.getString("telefono"),
                    rs.getDate("fechaNacimiento").toLocalDate()
            );
            copiaAlumnos.add(alumno);
        }

        return copiaAlumnos;

    }

    public int getTamano() throws SQLException {
        String query = """
	    		SELECT COUNT(dni) 
	    		FROM alumno
	    		""";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs.getInt(1);
    }


    public void insertar(Alumno alumno) throws OperationNotSupportedException, SQLException {
        if (alumno == null) {
            throw new NullPointerException("ERROR: No se puede insertar un alumno nulo.");
        }

        if (buscar(alumno) != null) {
            throw new OperationNotSupportedException("ERROR: Ya existe un alumno con ese dni.");
        }
        String query = """
    			INSERT INTO alumno
    				(nombre, 
    				telefono, 
    				correo, 
    				dni, 
    				fechaNacimiento) 
    			VALUES 
    				(?, ?, ?, ?, ?)
    			""";
        PreparedStatement pstmt = conexion.prepareStatement(query);
        pstmt.setString(1, alumno.getNombre());
        pstmt.setString(2, alumno.getTelefono());
        pstmt.setString(3, alumno.getCorreo());
        pstmt.setString(4, alumno.getDni());
        pstmt.setDate(5, java.sql.Date.valueOf(alumno.getFechaNacimiento()));
        pstmt.executeUpdate();
    }

    public Alumno buscar(Alumno alumno)  throws SQLException{
        if (alumno==null) {
            throw new NullPointerException("ERROR: No se puede buscar un alumno nulo.");
        }
        String query = """
        		SELECT nombre
        			, dni
        			, correo
        			, telefono
        			, fechaNacimiento 
        		FROM alumno 
        		WHERE dni = ?
        		""";

        PreparedStatement pstmt = conexion.prepareStatement(query);
        pstmt.setString(1, alumno.getDni());
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return new Alumno(
                    rs.getString("nombre"),
                    rs.getString("dni"),
                    rs.getString("correo"),
                    rs.getString("telefono"),
                    rs.getDate("fechaNacimiento").toLocalDate()
            );
        }
        return null;
    }

    public void borrar(Alumno alumno) throws OperationNotSupportedException, SQLException {
        if (alumno==null) {
            throw new NullPointerException("ERROR: No se puede borrar un alumno nulo.");
        }
        if (buscar(alumno) == null) {
            throw new OperationNotSupportedException("ERROR: No existe ningún alumno como el indicado.");
        }
        String query = """
        		DELETE FROM alumno
        		WHERE dni = ?
        		""";
        PreparedStatement pstmt = conexion.prepareStatement(query);
        pstmt.setString(1, alumno.getDni());
        pstmt.executeUpdate();
    }

    @Override
    public void comenzar() {
        conexion = MySQL.establecerConexion();

    }

    @Override
    public void terminar() {
        MySQL.cerrarConexion();
    }


}
