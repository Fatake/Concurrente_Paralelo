import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Alumno implements Runnable{
    private final String nombre;
    private final Materia[] materias;
    
    private final int limite;
    private int restantes;
    
    private final SecretariaAcademica sa;
    private CountDownLatch cdl;

    /**
     * Contruye un nuevo {@code Alumno} dado su nombre, arreglo de materias deseadas y
     * la secretaría academica a la que solicitara su inscripción en sus materias deseadas,
     * siempre y cuando no exceda su límite.
     * 
     * @param nombre Nombre del alumno
     * @param materias Arreglo de las materias en las que el alumno desea inscribirse
     * @param sa Secretaria academica a la que este alumno solicitará inscribir sus materias
     */
    public Alumno(String nombre, Materia[] materias, SecretariaAcademica sa, int limite) {
        this.nombre = nombre;
        this.materias = materias;
        this.sa = sa;
        this.limite = restantes = limite;
    }
    
    /**
     * Contruye un nuevo {@code Alumno} dado su nombre, arreglo de materias deseadas,
     * la secretaría academica a la que solicitara su inscripción en sus materias deseadas,
     * siempre y cuando no exceda su límite, y {@code CountDownLatch}
     * para controlar la concurrencia de los profesores.
     * 
     * @param nombre Nombre del alumno
     * @param materias Arreglo de las materias en las que el alumno desea inscribirse
     * @param sa Secretaria academica a la que este alumno solicitará inscribir sus materias
     * @param cdl CountDownLatch para controlar la concurrencia 
     */
    public Alumno(String nombre, Materia[] materias, SecretariaAcademica sa, CountDownLatch cdl, int limite){
        this.nombre = nombre;
        this.materias = materias;
        this.sa = sa;
        this.cdl = cdl;
        this.limite = restantes = limite;
    }
    
    /**
     * Retorna el nombre de este profesor
     * @return el nombre de este profesor.
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * Retorna número de materias límite que este alumno puede inscribir
     * @return número de materias límite que este alumno puede inscribir 
     */
    public int getLimite() {
        return limite;
    }
    
    /**
     * Retorna el número de materias restantes que este alumno puede inscribir
     * de tal forma que límite >= restantes >= 0
     * @return número de materias restantes que el alumno puede inscribir
     */
    public int getRestantes() {
        return restantes;
    }

    /**
     * Asigna la {@code CountDownLatch} a este alumno para controlar la concurrencia de alumnos.
     * @param cdl {@code CountDownLatch}
     */
    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    /**
     * Disminuye 1 a la variable restantes
     */
    public void inscrito(){
        restantes--;
    }
    
    /**
     * 
     */
    @Override
    public void run() {
        ExecutorService exs = Executors.newCachedThreadPool();
        CountDownLatch cdl = new CountDownLatch(materias.length);
        for (Materia materia : materias)
            exs.execute(() -> {
                sa.inscribirAlumno(this, materia);
                cdl.countDown();
            });
        exs.shutdown();

        try {
            cdl.await();
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
        
        this.cdl.countDown();
    }
}
