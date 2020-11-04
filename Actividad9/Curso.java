import java.util.ArrayList;

public class Curso {
    private final int NRC;
    private final Materia materia;
    private Profesor profesor;
    private final ArrayList<Alumno> alumnos;
    
    private final int cupo;
    private int disponibles;

    /**
     * Contruye un nuevo {@code Curso} dado su NRC, materia y
     * el cupo de alumnos que admitira el curso.
     * 
     * @param NRC NRC de la materia
     * @param materia Materia impartida en el curso
     * @param cupo Capacidad de Alumnos que tiene el curso
     */
    public Curso(int NRC, Materia materia, int cupo) {
        this.NRC = NRC;
        this.materia = materia;
        this.cupo = disponibles = cupo;
        
        this.profesor = null;
        this.alumnos = new ArrayList<>(cupo);
    }

    /**
     * Asigna el profesor que impartira este curso
     * @param profesor Profesor que impartira este curso
     */
    public void setProfesor(Profesor profesor){
        this.profesor = profesor;
    }
    
    /**
     * Retorna la capacidad de alumnos que tiene este curso
     * @return Capacidad de alumnos que tiene este curso
     */
    public int getCupo() {
        return cupo;
    }

    /**
     * Retorna la cantidad de lugares disponibles que tiene este curso
     * @return Cantidad de lugares disponibles que tiene este curso
     */
    public int getDisponibles() {
        return disponibles;
    }

    /**
     * Retorna el NRC de la materia
     * @return NRC de la materia
     */
    public int getNRC() {
        return NRC;
    }

    /**
     * Retorna la materia de este curso
     * @return Materia de este curso
     */
    public Materia getMateria() {
        return materia;
    }

    /**
     * Retorna el profesor de este curso, 
     * @return {@code Profesor} si hay profesor asignado, {@code null} si no.
     */
    public Profesor getProfesor() {
        return profesor;
    }

    /**
     * Retorna arreglo de alumnos inscritos en este curso
     * @return arreglo de alumnos inscritos en este curso
     */
    public Alumno[] getAlumnos() {
        return alumnos.toArray(new Alumno[alumnos.size()]);
    }
    
    /**
     * Inscribe el alumno especificado en este curso, siempre y cuando no este ya inscrito
     * y haya al menos un lugar disponible.
     * @param alumno Alumno a inscribir al curso
     * @return {@code true} si el alumno fue inscrito correctamente, {@code false} si no.
     */
    public boolean incribirAlumno(Alumno alumno){
        if (!alumnos.contains(alumno) && disponibles > 0){
            alumnos.add(alumno);
            disponibles--;
            return true;
        }
        return false;
    }
    
    /**
     * Verifica si hay profesor asignado en este curso
     * @return {@code true} si este curso tiene profesor asignado, {@code false} si no.
     */
    public boolean hayProfesorAsignado(){
        return profesor != null;
    }
    
    /**
     * Verifica si el alumno especificado está inscrito en este curso.
     * @param alumno
     * @return {@code true} si el alumno esta inscrito en este curso, {@code false} si no.
     */
    public boolean estaIncrito(Alumno alumno){
        return alumnos.contains(alumno);
    }
    
    /**
     * Verificica si aún hay cupo disponible en este curso
     * @return {@code true} si aún hay lugar disponible en este curso, {@code false} si no.
     */
    public boolean hayCupo(){
        return disponibles > 0;
    }

    @Override
    public String toString(){
        StringBuilder info = new StringBuilder();
        info.append("Materia: ").append(materia.getNombre()).append('\n');
        info.append("Profesor: ").append((profesor != null) ? profesor.getNombre() : "No hay profesor asignado\n").append('\n');
        if (disponibles < cupo){
            info.append("Alumnos: ").append('\n');
            for (Alumno alumno : alumnos){
                info.append(alumno.getNombre()).append('\n');
            }
        }else{
            info.append("No hay alumnos registrados");
        }
        return info.toString();
    }
}
