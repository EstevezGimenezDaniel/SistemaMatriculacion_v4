package org.iesalandalus.programacion.matriculacion.modelo.dominio;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Alumno {

    private static final String ER_TELEFONO = "\\d{9}";
    private static final String ER_CORREO = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    private static final String ER_DNI = "^(\\d{8})([A-Za-z]{1})$";
    public static final String FORMATO_FECHA = "dd/MM/yyyy";
    private static final String ER_NIA = "^([A-Za-zÁáÉéÍíÓóÚú]{4})(\\d{3})$";
    private static final int MIN_EDAD_ALUMNADO = 16;

    private String nombre;
    private String telefono;
    private String correo;
    private String dni;
    private LocalDate fechaNacimiento;
    private String nia;

    public Alumno(String nombre, String dni, String correo, String telefono, LocalDate fechaNacimiento) {
        setDni(dni);
        setNombre(nombre);
        setCorreo(correo);
        setTelefono(telefono);
        setFechaNacimiento(fechaNacimiento);
    }
    public Alumno(Alumno alumno) {
        Objects.requireNonNull(alumno, "ERROR: No es posible copiar un alumno nulo.");
        setDni(alumno.getDni());
        setNombre(alumno.getNombre());
        setCorreo(alumno.getCorreo());
        setTelefono(alumno.getTelefono());
        setFechaNacimiento(alumno.getFechaNacimiento());
    }


    public String getNia() {
        return this.nia;
    }

    private void setNia() {
        setNia(this.nombre.substring(0, 4).toLowerCase() + dni.substring(5, 8));
    }

    private void setNia(String nia) {
        Objects.requireNonNull(nia, "ERROR: El nia no puede ser nulo");
        if (!nia.matches(ER_NIA)) {
            throw new IllegalArgumentException("Nia incorrecto.");
        }
        this.nia = nia;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        Objects.requireNonNull(nombre, "ERROR: El nombre de un alumno no puede ser nulo.");
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("ERROR: El nombre de un alumno no puede estar vacío.");
        }
        this.nombre = formateaNombre(nombre);
        setNia();
    }
    private String formateaNombre(String nombre) {
        String[] tokens = nombre.trim().toLowerCase().split("[ ]+");
        String nombreCompleto = "";
        for (String token : tokens) {
            nombreCompleto += token.substring(0, 1).toUpperCase() + token.substring(1) + " ";
        }
        return nombreCompleto.trim();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        Objects.requireNonNull(telefono, "ERROR: El teléfono de un alumno no puede ser nulo.");
        if (!telefono.matches(ER_TELEFONO)) {
            throw new IllegalArgumentException("ERROR: El teléfono del alumno no tiene un formato válido.");
        }
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        Objects.requireNonNull(correo, "ERROR: El correo de un alumno no puede ser nulo.");
        if (!correo.matches(ER_CORREO)) {
            throw new IllegalArgumentException("ERROR: El correo del alumno no tiene un formato válido.");
        }
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    private void setDni(String dni) {
        Objects.requireNonNull(dni, "ERROR: El dni de un alumno no puede ser nulo.");
        if (!comprobarLetraDni(dni.toUpperCase())) {
            throw new IllegalArgumentException("ERROR: El dni del alumno no tiene un formato válido.");
        }
        this.dni = dni.toUpperCase();
    }

    private boolean comprobarLetraDni(String dni) {
        int numero;
        char letra;
        Pattern patron = Pattern.compile(ER_DNI);
        Matcher comparador = patron.matcher(dni);
        char[] LETRAS_DNI = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
                'H', 'L', 'C', 'K', 'E' };
        if (comparador.matches()) {
            numero = Integer.parseInt(comparador.group(1));
            letra = comparador.group(2).charAt(0);
        } else {
            return false;
        }
        int n = numero % 23;
        if (letra != LETRAS_DNI[n]) {
            throw new IllegalArgumentException("ERROR: La letra del dni del alumno no es correcta.");
        }
        return true;
    }
    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    private void setFechaNacimiento(LocalDate fechaNacimiento) {
        Objects.requireNonNull(fechaNacimiento, "ERROR: La fecha de nacimiento de un alumno no puede ser nula.");
        if ((LocalDate.now().getYear() - fechaNacimiento.getYear()) < MIN_EDAD_ALUMNADO) {
            throw new IllegalArgumentException("ERROR: La edad del alumno debe ser mayor o igual a 16 años.");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    private String getIniciales() {
        String[] tokens = nombre.trim().toUpperCase().split("[ ]+");
        String s = "";
        for (String token : tokens) {
            s += token.substring(0, 1);
        }
        return s;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(this.dni, alumno.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    public String imprimir() {
        return String.format("nombre=%s (%s), DNI=%s, correo=%s, teléfono=%s, fecha nacimiento=%s", this.getNombre(),
                this.getIniciales(), this.getDni(), this.getCorreo(), this.getTelefono(),
                this.getFechaNacimiento().format(DateTimeFormatter.ofPattern(FORMATO_FECHA)));
    }
    @Override
    public String toString() {
        return String.format(
                "Número de Identificación del Alumnado (NIA)=%s nombre=%s (%s), DNI=%s, correo=%s, teléfono=%s, fecha nacimiento=%s",
                this.getNia(), this.getNombre(), this.getIniciales(), this.getDni(), this.getCorreo(),
                this.getTelefono(), this.getFechaNacimiento().format(DateTimeFormatter.ofPattern(FORMATO_FECHA)));
    }
}