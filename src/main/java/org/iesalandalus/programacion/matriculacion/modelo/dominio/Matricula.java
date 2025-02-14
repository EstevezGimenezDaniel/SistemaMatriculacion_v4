package org.iesalandalus.programacion.matriculacion.modelo.dominio;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Objects;

public class Matricula {
    public static final int MAXIMO_MESES_ANTERIOR_ANULACION = 6;
    public static final int MAXIMO_DIAS_ANTERIOR_MATRICULA = 15;
    public static final int MAXIMO_NUMERO_HORAS_MATRICULA = 1000;
    public static final int MAXIMO_NUMERO_ASIGNATURAS_POR_MATRICULA = 10;
    private static final String ER_CURSO_ACADEMICO = "\\d{2}-\\d{2}";
    public static final String FORMATO_FECHA = "dd-MM-yyyy";
    private int idMatricula;
    private String cursoAcademico;
    private LocalDate fechaMatriculacion;
    private LocalDate fechaAnulacion;
    private Alumno alumno;
    private Asignatura[] coleccionAsignaturas;


    private boolean superaMaximoNumeroHorasMatricula(Asignatura[] asignaturasMatricula)  {
        if (asignaturasMatricula==null) {
            throw new NullPointerException("ERROR: La lista de asignaturas de una matr?cula no puede ser nula.");
        }
        int totalHoras = 0;

        for (int i=0; i< asignaturasMatricula.length; i++) {
            if (asignaturasMatricula[i]!=null) {
                totalHoras += asignaturasMatricula[i].getHorasAnuales();
            }
        }

        if (totalHoras > MAXIMO_NUMERO_HORAS_MATRICULA) {
            return true;
        }
        return false;
    }
    public Matricula(int idMatricula, String cursoAcademico, LocalDate fechaMatriculacion, Alumno alumno, Asignatura[] coleccionAsignaturas) throws OperationNotSupportedException {
        if (superaMaximoNumeroHorasMatricula(coleccionAsignaturas)) {
            throw new OperationNotSupportedException("ERROR: No se puede realizar la matr?cula ya que supera el m?ximo de horas permitidas (1000 horas).");
        }
        setIdMatricula(idMatricula);
        setCursoAcademico(cursoAcademico);
        setFechaMatriculacion(fechaMatriculacion);
        setAlumno(alumno);
        setColeccionAsignaturas(coleccionAsignaturas);

    }


    public Matricula(Matricula matricula) {
        if (matricula==null) {
            throw new NullPointerException("ERROR: No es posible copiar una matr?cula nula.");
        }

        this.idMatricula = matricula.idMatricula;
        this.cursoAcademico = matricula.cursoAcademico;
        this.fechaMatriculacion = matricula.fechaMatriculacion;
        this.fechaAnulacion = matricula.fechaAnulacion;
        this.alumno = matricula.alumno;
        this.coleccionAsignaturas = Arrays.copyOf(matricula.coleccionAsignaturas, matricula.coleccionAsignaturas.length);
    }

    public int getIdMatricula() {
        return idMatricula;
    }
    public void setIdMatricula(int idMatricula) {
        if (idMatricula <= 0) {
            throw new IllegalArgumentException("ERROR: El identificador de una matr?cula no puede ser menor o igual a 0.");
        }
        this.idMatricula = idMatricula;
    }
    public String getCursoAcademico() {
        return cursoAcademico;
    }
    public void setCursoAcademico(String cursoAcademico) {
        if (cursoAcademico==null) {
            throw new NullPointerException("ERROR: El curso acad?mico de una matr?cula no puede ser nulo.");
        }
        if (cursoAcademico.isBlank()) {
            throw new IllegalArgumentException("ERROR: El curso acad?mico de una matr?cula no puede estar vac?o.");
        }
        if ( cursoAcademico.isEmpty()) {
            throw new IllegalArgumentException("ERROR: El curso acad?mico de una matr?cula no puede estar vac?o.");
        }
        if (!cursoAcademico.matches(ER_CURSO_ACADEMICO)) {
            throw new IllegalArgumentException("ERROR: El formato del curso acad?mico no es correcto.");
        }
        this.cursoAcademico = cursoAcademico;
    }

    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        if (fechaMatriculacion == null) {
            throw new NullPointerException("ERROR: La fecha de matriculaci?n de una m?tricula no puede ser nula.");
        }
        if (fechaMatriculacion.isAfter(LocalDate.now().plusDays(MAXIMO_DIAS_ANTERIOR_MATRICULA))) {
            throw new IllegalArgumentException("La fecha de matriculaci?n no puede superar los 15 d?as de retraso.");
        }
        if (fechaMatriculacion.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("ERROR: La fecha de matriculaci?n no puede ser posterior a hoy.");
        }
        if (fechaMatriculacion.isBefore(LocalDate.now().minusDays(MAXIMO_DIAS_ANTERIOR_MATRICULA))) {
            throw new IllegalArgumentException("ERROR: La fecha de matriculaci?n no puede ser anterior a 15 d?as.");
        }


        this.fechaMatriculacion = fechaMatriculacion;
    }

    public LocalDate getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(LocalDate fechaAnulacion) {

        if (fechaAnulacion.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("ERROR: La fecha de anulaci?n de una matr?cula no puede ser posterior a hoy.");
        }
        if (fechaAnulacion.isBefore(fechaMatriculacion)) {
            throw new IllegalArgumentException("ERROR: La fecha de anulaci?n no puede ser anterior a la fecha de matriculaci?n.");
        }

        if (fechaAnulacion.isAfter(fechaMatriculacion.plusMonths(MAXIMO_MESES_ANTERIOR_ANULACION))) {
            throw new IllegalArgumentException("ERROR: La edad del alumno debe ser mayor o igual a 16 a?os");
        }
        long mesesDeDiferencia = ChronoUnit.MONTHS.between(fechaAnulacion, LocalDate.now());
        if (mesesDeDiferencia>=MAXIMO_MESES_ANTERIOR_ANULACION) {
            throw new IllegalArgumentException("ERROR: La fecha de anulaci?n debe ser anterior a 6 meses");
        }

        this.fechaAnulacion = fechaAnulacion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno)  {
        if (alumno == null) {
            throw new NullPointerException("ERROR: El alumno de una matr?cula no puede ser nulo.");
        }

        this.alumno = alumno;
    }

    public Asignatura[] getColeccionAsignaturas() {

        return coleccionAsignaturas;
    }

    public void setColeccionAsignaturas(Asignatura[] coleccionAsignaturas) throws OperationNotSupportedException {

        if (coleccionAsignaturas==null) {
            throw new NullPointerException("ERROR: La lista de asignaturas de una matr?cula no puede ser nula.");
        }
        if (coleccionAsignaturas.length > MAXIMO_NUMERO_ASIGNATURAS_POR_MATRICULA) {
            throw new IllegalArgumentException("ERROR: El n?mero de asignaturas no puede superar el m?ximo permitido");
        }

        this.coleccionAsignaturas = coleccionAsignaturas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matricula matricula = (Matricula) o;
        return idMatricula == matricula.idMatricula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMatricula);
    }

    private String asignaturasMatricula() {
        if (coleccionAsignaturas.length == 0) {
            return "Sin asignaturas";
        }
        StringBuilder asignaturasTexto = new StringBuilder();
        for (Asignatura asignatura : coleccionAsignaturas) {
            if (asignatura != null) {
                asignaturasTexto.append(asignatura.imprimir()).append(", ");
            }
        }
        return asignaturasTexto.toString();
    }

    // TODO
    public String imprimir(){
        return "idMatricula=" + getIdMatricula() + ", " +
                "curso acad?mico=" + getCursoAcademico() + ", " +
                "fecha matriculaci?n=" + getFechaMatriculacion().format(DateTimeFormatter.ofPattern(FORMATO_FECHA)) + ", " +
                "alumno=" + "{" + getAlumno().imprimir() + "}";
    }
    @Override
    public String toString() {
        if (fechaAnulacion == null){
            return "idMatricula=" + getIdMatricula() + ", " +
                    "curso acad?mico=" + getCursoAcademico() + ", " +
                    "fecha matriculaci?n=" + getFechaMatriculacion().format(DateTimeFormatter.ofPattern(FORMATO_FECHA)) + ", " +
                    "alumno=" + getAlumno().imprimir() + ", " +
                    "Asignaturas=" + "{ " + asignaturasMatricula() + "}";

        } else return "idMatricula=" + getIdMatricula() + ", " +
                "curso acad?mico=" + getCursoAcademico() + ", " +
                "fecha matriculaci?n=" + getFechaMatriculacion().format(DateTimeFormatter.ofPattern(FORMATO_FECHA)) + ", " +
                "fecha anulaci?n=" + getFechaAnulacion().format(DateTimeFormatter.ofPattern(FORMATO_FECHA)) + ", " +
                "alumno=" + getAlumno().imprimir() + ", " +
                "Asignaturas=" + "{ " + asignaturasMatricula() + "}";
    }
}
