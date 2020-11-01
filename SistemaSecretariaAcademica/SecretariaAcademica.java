import java.util.ArrayList;

public class SecretariaAcademica {
    private static int NRC = 10000;
    private final ArrayList<Curso> cursos;
    
    
    public SecretariaAcademica(Materia[] materias){
        this.cursos = new ArrayList<>();
        crearCursos(materias);
    }
    
    /**
     * 
     * @param materias
     */
    private void crearCursos(Materia[] materias){
        for (Materia materia : materias){
            cursos.add(new Curso(NRC++, materia, 3));
        }  
    }
    
    /**
     * Retorna la primera ocurrencia del curso con la materia especificada, {@code null} si no hay
     * cursos con la materia.
     * @param materia
     * @return la primera ocurrencia del curso con la materia especificada {@code null} si no.
     */
    public Curso getCurso(Materia materia){
        for (Curso curso : cursos){
            if (curso.getMateria().equals(materia))
                return curso;
        }
        return null;
    }
    
    /**
     * Retorna en arreglo de cursos con la materia especificada, {@code null} si no hay
     * cursos con la materia.
     * @param materia
     * @return arreglo de cursos con la materia especificada, {@code null} si no.
     */
    public Curso[] getCursos(Materia materia){
        ArrayList<Curso> cursos = new ArrayList<>();
        for (Curso curso : this.cursos)
            if (curso.getMateria().equals(materia))
                cursos.add(curso);
        return (cursos.isEmpty() ? null : cursos.toArray(new Curso[cursos.size()]));
    }

    /**
     * Retorna un arreglo con todos los cursos
     * @return un arreglo con todos los cursos
     */
    public Curso[] getCursos() {
        return cursos.toArray(new Curso[cursos.size()]);
    }

    /**
     * Asigna al profesor especificado, en algún curso que tenga la materia especificada.
     * @param profesor Profesor a asignar al curso
     * @param materia Materia que el curso debe tener
     * @return 
     */
    public void registrarProfesor(Profesor profesor, Materia materia){
        Curso[] cursos = getCursos(materia);
        for (Curso curso : cursos){
            synchronized (curso){
                if (!curso.hayProfesorAsignado()){
                    curso.setProfesor(profesor);
                    profesor.inscrito();
                    System.out.println("Se asignó al profesor " + profesor.getNombre() + " a la materia: " + materia.getNombre() + " con NRC: " + curso.getNRC());
                }else
                    System.out.println("El curso de la materia: " + materia.getNombre() + " con NRC: " + curso.getNRC() + ", ya tiene profesor asignado");
            }
        }
    }
    
    
    /**
     * Inscribe al alumno especificado en algún curso que tenga la materia especificada.
     * @param alumno Alumno a inscribir en el curso
     * @param materia Materia que el curso debe tener
     * @return 
     */
    public void inscribirAlumno(Alumno alumno, Materia materia){
        Curso[] cursos = getCursos(materia);
        for (Curso curso : cursos)
            if (curso.estaIncrito(alumno))
                System.out.println("El alumno " + alumno.getNombre() + " ya se incribió anteriormente en el curso de la materia " + materia.getNombre() + " con NRC: " + curso.getNRC());
        
        for (Curso curso : cursos){
            synchronized (curso){
                if (curso.hayCupo()){
                    curso.incribirAlumno(alumno);
                    alumno.inscrito();
                }else
                    System.out.println("La materia: " + materia.getNombre() + " con NRC: " + curso.getNRC() + ", no tiene espacio disponible"); 
            }
        } 
    }
}
