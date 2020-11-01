import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class SecretariaAcademica {
    private static final String FILE_NAME = "materias.txt";
    private static int NRC = 10000;
    private final ArrayList<Curso> cursos;
    private Materia[] materias;
    
    private File archivo = null;
    private FileReader fr = null;
    private BufferedReader br = null;
    
    public SecretariaAcademica(){
        this.materias = leeArchivo();
        this.cursos = crearCursos(materias,3);
    }
    
    /**
     * Funcion que genera cursos dados una materia
     * @param materias
     */
    public ArrayList<Curso> crearCursos(Materia[] materias, int cupo){
        ArrayList<Curso> lista = new ArrayList<>();
        for (Materia materia : materias){
            lista.add(new Curso(NRC++, materia, cupo));
        }
        return lista;
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

    /**
     * Lee el archivo Materias.txt
     * Retorna una arreglo de materias
     * @return
     */
    private Materia[] leeArchivo(){
        ArrayList<Materia> mat = new ArrayList<>();
        try {
            archivo = new File (FILE_NAME);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            int contador = 1;
            String linea;
            while((linea = br.readLine())!=null){
                contador ++;
                mat.add(new Materia(""+contador, linea));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            try{                    
                if( null != fr ){   
                    fr.close();  
                }                  
            }catch (Exception e2){ 
                e2.printStackTrace();
                return null;
            }
        }
        Materia[] mater = new Materia[mat.size()];
        return mat.toArray(mater);
    }

    /**
     * Retona un arreglo de materias
     * @return
     */
    public Materia[] getMaterias(){
            return this.materias;
    }
}
