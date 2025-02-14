package org.iesalandalus.programacion.matriculacion.modelo.dominio;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Alumno {

    private final String ER_TELEFONO="^\\d{9}$";
    private final String ER_CORREO="^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
    private final String ER_DNI="^\\d{8}[A-HJ-NP-TV-Z]$";
    public static final String FORMATO_FECHA="dd/MM/yyyy";
    private final String ER_NIA="";
    private final int MIN_EDAD_ALUMNADO=16;
/*
    private String nombre;
    private String telefono;
    private String correo;
    private String dni;
    private LocalDate fechaNacimiento;
    private  String nia;



    private String nombre="Andr?s Rubio Del R?o";
    private String telefono="666223344";
    private String correo="andres.rubio@iesalandalus.org";
    private String dni="22334455Y";
    private LocalDate fechaNacimiento= LocalDate.of(1992, 07, 03);
    private  String nia="andr455";
*/
    private String nombre="Jos? Ram?n Jim?nez Reyes";
    private String telefono="950112233";
    private String correo="joseramon.jimenez@iesalandalus.org";
    private String dni="11223344B";
    private LocalDate fechaNacimiento= LocalDate.of(2002, 9, 15);
    private  String nia="jos?344";

    public Alumno(String nombre, String dni, String correo, String telefono, LocalDate fechaNacimiento) {
        setNombre(nombre);
        setDni(dni);
        setCorreo(correo);
        setTelefono(telefono);
        setFechaNacimiento(fechaNacimiento);
    }

    public Alumno(Alumno alumno) {
        if(alumno==null) {
            throw new NullPointerException("ERROR: No es posible copiar un alumno nulo.");
        }
        setNombre(alumno.getNombre());
        setDni(alumno.getDni());
        setCorreo(alumno.getCorreo());
        setTelefono(alumno.getTelefono());
        setFechaNacimiento(alumno.getFechaNacimiento());
        setNia();

    }

    public String getNia() {

        return nia;
    }
    private void setNia(String nia) {

        if (nombre != null && dni != null) {
            String primeraParte = nombre.toLowerCase().replaceAll("\\s+", "").substring(0, Math.min(4, nombre.length()));
            String ultimaParte = dni.substring(dni.length() - 3);

            this.nia = primeraParte + ultimaParte;
        }
    }
    private void setNia() {
        if (nia==null) {
            throw new NullPointerException("ERROR: El nia no puede ser nulo.");
        }
        if (nia.isEmpty()) {
            throw new IllegalArgumentException("El nia no puede estar vacio");
        }
        if (nia.isBlank()) {
            throw new IllegalArgumentException("El nia no puede estar en blanco");
        }
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if (nombre==null) {
            throw new NullPointerException("ERROR: El nombre de un alumno no puede ser nulo.");
        }
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("ERROR: El nombre de un alumno no puede estar vac?o.");
        }
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("ERROR: El nombre de un alumno no puede estar vac?o.");
        }
        this.nombre = getNombre();
    }
    private String formateaNombre(String nombre) {
        String[] palabras = nombre.trim().toLowerCase().split("\\s+");
        StringBuilder nombreFormateado = new StringBuilder();

        for (String palabra : palabras) {
            nombreFormateado.append(Character.toUpperCase(palabra.charAt(0)))
                    .append(palabra.substring(1))
                    .append(" ");
        }
        return nombreFormateado.toString().trim();
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        if (telefono==null) {
            throw new NullPointerException("ERROR: El tel?fono de un alumno no puede ser nulo.");
        }
        if (telefono.isEmpty()) {
            throw new IllegalArgumentException("ERROR: El tel?fono del alumno no tiene un formato v?lido.");
        }
        if (telefono.isBlank()) {
            throw new IllegalArgumentException("ERROR: El tel?fono del alumno no tiene un formato v?lido.");
        }
        if (!telefono.matches(ER_TELEFONO)) {
            throw new IllegalArgumentException("ERROR: El tel?fono del alumno no tiene un formato v?lido.");
        }
        this.telefono=getTelefono();
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        if (correo==null) {
            throw new NullPointerException("ERROR: El correo de un alumno no puede ser nulo.");
        }
        if (correo.isEmpty()) {
            throw new IllegalArgumentException("ERROR: El correo del alumno no tiene un formato v?lido.");
        }
        if (correo.isBlank()) {
            throw new IllegalArgumentException("ERROR: El correo del alumno no tiene un formato v?lido.");
        }
        if(!correo.matches(ER_CORREO)){
            throw new IllegalArgumentException("ERROR: El correo del alumno no tiene un formato v?lido.");
        }
    }
    public String getDni() {

        return dni;
    }
    private void setDni(String dni) {
        if (dni == null) {
            throw new NullPointerException("ERROR: El dni de un alumno no puede ser nulo.");
        }

        if (dni.isEmpty()) {
            throw new IllegalArgumentException("ERROR: El dni del alumno no tiene un formato v?lido.");
        }
        if (dni.isBlank()) {
            throw new IllegalArgumentException("ERROR: El dni del alumno no tiene un formato v?lido.");
        }
        if (dni.length() != 9) {
            throw new IllegalArgumentException("ERROR: El dni del alumno no tiene un formato v?lido.");
        }
        if (!dni.matches(ER_DNI) || !comprobarLetraDni(dni)){
            throw new IllegalArgumentException("ERROR: La letra del dni del alumno no es correcta.");
        }
        if (!comprobarLetraDni(dni)) {
            throw new IllegalArgumentException("ERROR: La letra del dni del alumno no es correcta.");
        }
    }
    private boolean comprobarLetraDni(String dni) {
        int numero = Integer.parseInt(dni.substring(0, 8));
        char letra = dni.charAt(8);
        final char[] LETRAS_DNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J',
                'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        return letra == LETRAS_DNI[numero % 23];
    }
    public LocalDate getFechaNacimiento() {

        return fechaNacimiento;
    }
    private void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento==null) {
            throw new NullPointerException("ERROR: La fecha de nacimiento de un alumno no puede ser nula.");
        }
        LocalDate hoy = LocalDate.now();
        int edad = hoy.getYear() - fechaNacimiento.getYear();

        if (fechaNacimiento.plusYears(edad).isAfter(hoy)) {
            edad--;
        }
        if (edad < MIN_EDAD_ALUMNADO) {
            throw new IllegalArgumentException("ERROR: La edad del alumno debe ser mayor o igual a " + MIN_EDAD_ALUMNADO + " a?os.");
        }
        this.fechaNacimiento = getFechaNacimiento();
    }

    private String getIniciales() {
        String[] palabras = nombre.split("\\s+");
        StringBuilder iniciales = new StringBuilder();

        for (String palabra : palabras) {
            iniciales.append(palabra.charAt(0));
        }
        return iniciales.toString().toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre) &&
                Objects.equals(telefono, alumno.telefono) &&
                Objects.equals(correo, alumno.correo) &&
                Objects.equals(dni, alumno.dni) &&
                Objects.equals(fechaNacimiento, alumno.fechaNacimiento) &&
                Objects.equals(nia, alumno.nia);
    }
    @Override
    public int hashCode() {
        return Objects.hash(ER_TELEFONO, ER_CORREO, ER_DNI, FORMATO_FECHA, ER_NIA, MIN_EDAD_ALUMNADO, nombre, telefono, correo, dni, fechaNacimiento, nia);
    }
    public String imprimir() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA);
        String fechaFormateada = fechaNacimiento.format(formatter);
        return "N?mero de Identificaci?n del Alumnado (NIA)=" + nia + " nombre=" + nombre + " (" + getIniciales() + "), DNI=" + dni + ", correo=" + correo + ", tel?fono=" + telefono + ", fecha nacimiento=" + fechaFormateada;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA);
        String fechaFormateada = fechaNacimiento.format(formatter);
        return "N?mero de Identificaci?n del Alumnado (NIA)=" + nia + " nombre=" + nombre + " (" + getIniciales() + "), DNI=" + dni + ", correo=" + correo + ", tel?fono=" + telefono + ", fecha nacimiento=" + fechaFormateada;
    }

}
