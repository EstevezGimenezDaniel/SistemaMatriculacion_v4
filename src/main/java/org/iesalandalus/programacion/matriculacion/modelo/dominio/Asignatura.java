package org.iesalandalus.programacion.matriculacion.modelo.dominio;

import java.util.Objects;

public class Asignatura {
    public static final int MAX_NUM_HORAS_ANUALES = 300;
    public static final int MAX_NUM_HORAS_DESDOBLES = 6;
    private static final String ER_CODIGO="";
    private String codigo;
    private String nombre;
    private int horasAnuales;
    private Curso curso;
    private int horasDesdoble;
    private EspecialidadProfesorado especialidadProfesorado;
    private CicloFormativo cicloFormativo;

    public Asignatura(String codigo, String nombre, int horasAnuales, Curso curso, int horasDesdoble, EspecialidadProfesorado especialidadProfesorado, CicloFormativo cicloFormativo) {
        setCodigo(codigo);
        setNombre(nombre);
        setHorasAnuales(horasAnuales);
        setCurso(curso);
        setHorasDesdoble(horasDesdoble);
        setEspecialidadProfesorado(especialidadProfesorado);
        setCicloFormativo(cicloFormativo);
    }

    public Asignatura(Asignatura asignatura) {
        if (asignatura == null) {
            throw new NullPointerException("ERROR: No es posible copiar una asignatura nula.");
        }
        setCodigo(asignatura.getCodigo());
        setNombre(asignatura.getNombre());
        setHorasAnuales(asignatura.getHorasAnuales());
        setCurso(asignatura.getCurso());
        setHorasDesdoble(asignatura.getHorasDesdoble());
        setEspecialidadProfesorado(asignatura.getEspecialidadProfesorado());
        setCicloFormativo(asignatura.getCicloFormativo());
    }

    public Asignatura() {

    }

    private void setCodigo(String codigo) {
        if (codigo == null) {
            throw new NullPointerException("ERROR: El c?digo de una asignatura no puede ser nulo.");
        }
        if (codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: El c?digo de una asignatura no puede estar vac?o.");
        }
        if (!codigo.matches("\\d{4}")) {
            throw new IllegalArgumentException("ERROR: El c?digo de la asignatura no tiene un formato v?lido.");
        }
        this.codigo = codigo;
    }
    public void setNombre(String nombre) {
        if (nombre == null) {
            throw new NullPointerException("ERROR: El nombre de una asignatura no puede ser nulo.");
        }
        if (nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: El nombre de una asignatura no puede estar vac?o.");
        }
        this.nombre = nombre;
    }

    public void setHorasAnuales(int horasAnuales) {
        if (horasAnuales <= 0 || horasAnuales > MAX_NUM_HORAS_ANUALES) {
            throw new IllegalArgumentException("ERROR: El n?mero de horas de una asignatura no puede ser menor o igual a 0 ni mayor a "
                    + MAX_NUM_HORAS_ANUALES + ".");
        }
        this.horasAnuales = horasAnuales;
    }

    public void setCurso(Curso curso) {
        if (curso == null) {
            throw new NullPointerException("ERROR: El curso de una asignatura no puede ser nulo.");
        }
        this.curso = curso;
    }

    public void setHorasDesdoble(int horasDesdoble) {
        if (horasDesdoble < 0 || horasDesdoble > MAX_NUM_HORAS_DESDOBLES) {
            throw new IllegalArgumentException("ERROR: El n?mero de horas de desdoble de una asignatura no puede ser menor a 0 ni mayor a "
                    + MAX_NUM_HORAS_DESDOBLES + ".");
        }
        this.horasDesdoble = horasDesdoble;
    }

    public void setEspecialidadProfesorado(EspecialidadProfesorado especialidadProfesorado) {
        if (especialidadProfesorado == null) {
            throw new NullPointerException("ERROR: La especialidad del profesorado de una asignatura no puede ser nula.");
        }
        this.especialidadProfesorado = especialidadProfesorado;
    }

    public void setCicloFormativo(CicloFormativo cicloFormativo) {
        if (cicloFormativo == null) {
            throw new NullPointerException("ERROR: El ciclo formativo de una asignatura no puede ser nulo.");
        }
        this.cicloFormativo = cicloFormativo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHorasAnuales() {
        return horasAnuales;
    }

    public Curso getCurso() {
        return curso;
    }

    public int getHorasDesdoble() {
        return horasDesdoble;
    }

    public EspecialidadProfesorado getEspecialidadProfesorado() {
        return especialidadProfesorado;
    }

    public CicloFormativo getCicloFormativo() {
        return cicloFormativo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Asignatura other = (Asignatura) obj;
        return Objects.equals(codigo, other.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }


    public String imprimir() {
        return "C?digo asignatura=" + codigo + ", nombre asignatura=" + nombre
                + ", ciclo formativo=C?digo ciclo formativo=" + cicloFormativo.getCodigo() + ", nombre ciclo formativo="
                + cicloFormativo.getNombre();
    }
    @Override
    public String toString() {
        return "C?digo=" + codigo + ", nombre=" + nombre + ", horas anuales=" + horasAnuales + ", curso=" + curso
                + ", horas desdoble=" + horasDesdoble + ", ciclo formativo=C?digo ciclo formativo="
                + cicloFormativo.getCodigo() + ", nombre ciclo formativo=" + cicloFormativo.getNombre()
                + ", especialidad profesorado=" + especialidadProfesorado;
    }


}
