import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


public class Profesor implements Runnable{
    private final String nombre;
    private final Materia[] materias;
    
    private final int limite;
    private int restantes;
    
    private final SecretariaAcademica sa;
    private CountDownLatch cdl;

    /**
     * Contruye un nuevo {@code Profesor} dado su nombre, arreglo de materias deseadas y
     * la secretaría academica a la que solicitara su asignación en sus materias deseadas,
     * siempre y cuando no exceda su límite.
     * 
     * @param nombre Nombre del profesor
     * @param materias Arreglo de las materias que el profesor quisiera impartir
     * @param sa Secretaria academica a la que este profesor solicitará su asignación en las materias
     */
    public Profesor(String nombre, Materia[] materias, SecretariaAcademica sa, int limite) {
        this.nombre = nombre;
        this.materias = materias;
        this.sa = sa;
        this.limite = restantes = limite;
    }

    /**
     * Contruye un nuevo {@code Profesor} dado su nombre, arreglo de materias deseadas,
     * la secretaría academica a la que solicitara su asignación en sus materias deseadas,
     * siempre y cuando no exceda su límite, y {@code CountDownLatch}
     * para controlar la concurrencia de los profesores.
     * 
     * @param nombre Nombre del profesor
     * @param materias Arreglo de las materias que el profesor quisiera impartir
     * @param sa Secretaria academica a la que este profesor solicitará su asignación en las materias
     * @param cdl CountDownLatch para controlar la concurrencia
     */
    public Profesor(String nombre, Materia[] materias, SecretariaAcademica sa, CountDownLatch cdl, int limite) {
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
     * Retorna número de materias límite que este profesor puede solicitar su asignación
     * @return número de materias límite que este profesor puede solicitar su asignación 
     */
    public int getLimite() {
        return limite;
    }

    /**
     * Retorna el número de materias restantes que el profesor puede solicitar su asignación
     * de tal forma que limite >= restantes >= 0
     * @return número de materias restantes que el profesor puede solicitar su asignación
     */
    public int getRestantes() {
        return restantes;
    }

    /**
     * Asigna la {@code CountDownLatch} a este profesor para controlar la concurrencia de profesores.
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
                sa.registrarProfesor(this, materia);
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
