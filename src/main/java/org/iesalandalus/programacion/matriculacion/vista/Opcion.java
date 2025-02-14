package org.iesalandalus.programacion.matriculacion.vista;

public enum Opcion {
    SALIR("Salir") {
        @Override
        public void ejecutar() {
            System.out.println("Hasta luego!!");
            vista.terminar();
        }
    },
    INSERTAR_ALUMNO("Insertar Alumno") {
        @Override
        public void ejecutar() {
            System.out.println("Insertar alumno");
            vista.insertarAlumno();
        }
    },
    BUSCAR_ALUMNO("Buscar Alumno") {
        @Override
        public void ejecutar() {
            System.out.println("Buscar alumno");
            vista.buscarAlumno();
        }
    },
    BORRAR_ALUMNO("Borrar Alumno") {
        @Override
        public void ejecutar() {
            System.out.println("Borrar alumno");
            vista.borrarAlumno();
        }
    },
    MOSTRAR_ALUMNOS("Mostrar Alumnos") {
        @Override
        public void ejecutar() {
            System.out.println("Mostrar alumnos");
            vista.mostrarAlumnos();
        }
    },
    INSERTAR_CICLO_FORMATIVO("Insertar Ciclo Formativo") {
        @Override
        public void ejecutar() {
            System.out.println("Insertar ciclo formativo");
            vista.insertarCicloFormativo();
        }
    },
    BUSCAR_CICLO_FORMATIVO("Buscar Ciclo Formativo") {
        @Override
        public void ejecutar() {
            System.out.println("Buscar ciclo formativo");
            vista.buscarCicloFormativo();
        }
    },
    BORRAR_CICLO_FORMATIVO("Borrar Ciclo Formativo") {
        @Override
        public void ejecutar() {
            System.out.println("Borrar ciclo formativo");
            vista.borrarCicloFormativo();
        }
    },
    MOSTRAR_CICLOS_FORMATIVOS("Mostrar Ciclos Formativos") {
        @Override
        public void ejecutar() {
            System.out.println("Mostrar ciclos formativos");
            vista.mostrarCiclosFormativos();
        }
    },
    INSERTAR_ASIGNATURA("Insertar Asignatura") {
        @Override
        public void ejecutar() {
            System.out.println("Insertar asignatura");
            vista.insertarAsignatura();
        }
    },
    BUSCAR_ASIGNATURA("Buscar Asignatura") {
        @Override
        public void ejecutar() {
            System.out.println("Buscar asignatura");
            vista.buscarAsignatura();
        }
    },
    BORRAR_ASIGNATURA("Borrar Asignatura") {
        @Override
        public void ejecutar() {
            System.out.println("Borrar asignatura");
            vista.buscarAsignatura();
        }
    },
    MOSTRAR_ASIGNATURAS("Mostrar Asignaturas") {
        @Override
        public void ejecutar() {
            System.out.println("Mostrar asignaturas");
            vista.mostrarAsignaturas();
        }
    },
    INSERTAR_MATRICULA("Insertar Matr?cula") {
        @Override
        public void ejecutar() {
            System.out.println("Insertar matricula");
            vista.insertarMatricula();
        }
    },
    BUSCAR_MATRICULA("Buscar Matr?cula") {
        @Override
        public void ejecutar() {
            System.out.println("Buscar matricula");
            vista.buscarMatricula();
        }
    },
    ANULAR_MATRICULA("Anular Matr?cula") {
        @Override
        public void ejecutar() {
            System.out.println("Borrar matricula");
            vista.anularMatricula();
        }
    },
    MOSTRAR_MATRICULAS("Mostrar Matr?culas") {
        @Override
        public void ejecutar() {
            System.out.println("Mostrar matriculas");
            vista.mostrarMatriculas();
        }
    },
    MOSTRAR_MATRICULAS_ALUMNO("Mostrar Matr?culas Alumno") {
        @Override
        public void ejecutar() {
            System.out.println("Mostrar matriculas alumno");
            vista.mostrarMatriculas();
        }
    },
    MOSTRAR_MATRICULAS_CICLO_FORMATIVO("Mostrar Matr?culas Ciclo Formativo") {
        @Override
        public void ejecutar() {
            System.out.println("Mostrar matriculas ciclo formativo");
            vista.mostrarMatriculasPorCicloFormativo();
        }
    },
    MOSTRAR_MATRICULAS_CURSO_ACADEMICO("Mostrar Matr?culas Curso Acad?mico") {
        @Override
        public void ejecutar() {
            System.out.println("Mostrar matriculas curso academico");
            vista.mostrarMatriculasPorCursoAcademico();
        }
    };

    private final String cadenaAMostrar;

    private static Vista vista;

    private Opcion(String cadenaAMostrar) {

        this.cadenaAMostrar = cadenaAMostrar;
    }

    public abstract void ejecutar();

    public static void setVista(Vista vista) {
        Opcion.vista =vista;
    }

    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}
