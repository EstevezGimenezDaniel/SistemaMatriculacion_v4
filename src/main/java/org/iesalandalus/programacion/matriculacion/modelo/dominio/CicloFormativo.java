package org.iesalandalus.programacion.matriculacion.modelo.dominio;

import java.util.Objects;

public class CicloFormativo {
    private int codigo;
    private String familiaProfesional;
    private Grado grado;
    private String nombre;
    private int horas;
    public static final int MAXIMO_NUMERO_HORAS=2000;

    public CicloFormativo (int codigo, String familiaProfesional, Grado grado, String nombre, int horas) {
        setCodigo(codigo);
        setFamiliaProfesional(familiaProfesional);
        setGrado(grado);
        setNombre(nombre);
        setHoras(horas);
    }
    public CicloFormativo(CicloFormativo cicloFormativo) {
        if (cicloFormativo == null) {
            throw new NullPointerException("ERROR: No es posible copiar un ciclo formativo nulo.");
        }

        this.codigo = cicloFormativo.codigo;
        this.familiaProfesional = cicloFormativo.familiaProfesional;
        this.grado = cicloFormativo.grado;
        this.nombre = cicloFormativo.nombre;
        this.horas = cicloFormativo.horas;
    }
    public int getCodigo() {
        return codigo;
    }
    private void setCodigo(int codigo) {
        if (codigo < 1000 || codigo > 9999) {
            throw new IllegalArgumentException("El codigo debe estar entre los valores");
        }
        this.codigo = codigo;
    }
    public String getFamiliaProfesional() {
        return familiaProfesional;
    }

    public void setFamiliaProfesional(String familiaProfesional) {
        if (familiaProfesional==null) {
            throw new NullPointerException("ERROR: La familia profesional de un ciclo formativo no puede ser nula.");
        }
        if (familiaProfesional.isEmpty()) {
            throw new IllegalArgumentException("ERROR: La familia profesional no puede estar vac?a.");
        }
        if (familiaProfesional.isBlank()) {
            throw new IllegalArgumentException("ERROR: La familia profesional no puede estar vac?a.");
        }
        this.familiaProfesional = familiaProfesional;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        if (grado==null) {
            throw new NullPointerException("ERROR: El grado de un ciclo formativo no puede ser nulo.");
        }
        this.grado=grado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre==null) {
            throw new NullPointerException("ERROR: El nombre de un ciclo formativo no puede ser nulo.");
        }
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("ERROR: El nombre de un ciclo formativo no puede estar vac?o.");
        }
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("ERROR: El nombre de un ciclo formativo no puede estar vac?o.");
        }
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        if(horas==0) {
            throw new IllegalArgumentException("ERROR: El n?mero de horas de un ciclo formativo no puede ser menor o igual a 0 ni mayor a 2000.");
        }
        if (horas < 0) {
            throw new IllegalArgumentException("ERROR: El n?mero de horas de un ciclo formativo no puede ser menor o igual a 0 ni mayor a 2000.");
        }
        if (horas > MAXIMO_NUMERO_HORAS) {
            throw new IllegalArgumentException("ERROR: El n?mero de horas de un ciclo formativo no puede ser menor o igual a 0 ni mayor a 2000.");
        }
        this.horas = horas;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CicloFormativo that = (CicloFormativo) obj;
        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(MAXIMO_NUMERO_HORAS, codigo, familiaProfesional, grado, nombre, horas);
    }

    public String imprimir() {
        return String.format("C?digo ciclo formativo=" + codigo + ", nombre ciclo formativo=" + nombre);
    }

    @Override
    public String toString() {
        return "C?digo ciclo formativo=" + codigo + ", familia profesional=" + familiaProfesional + ", grado=" + grado
                + ", nombre ciclo formativo=" + nombre + ", horas=" + horas;

    }
}
