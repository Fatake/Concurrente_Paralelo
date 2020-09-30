import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**  
 *  Benemérita Universidad Autónoma de Puebla
 *  Programación Concurrente y Paralela
 *  Integrantes:
 *  Arizmendi Ramírez Esiel Kevin, 201737811
 *  Coria Rios Marco Antonio, 201734576
 *  Ruiz Lozano Paulo Cesar, 201734576
 */

/**
 * Primer hilo en ejecutarse. Crea la lista de figuras {@link Square} y
 * el objeto (hilo) de clase {@link Carpet}, al cual le pasa la lista creada.
 * También contiene el método <code>main</code>.
 */

public class Test{
    private ExecutorService es;
    private Random rand;
    private Carpet carpet;
    
    //Numero maximo de Cuadrados
    public static final int MAX_SQUARES = 10;

    /**
     * Constructor
     * @throws InterruptedException
     */
    public Test() throws InterruptedException {  };

    /**
     * Ejecutor
     * @throws InterruptedException
     */
    public void ejecutar() throws InterruptedException{
        rand = new Random();
        ArrayList<Square> squares = new ArrayList<>();
        es = Executors.newCachedThreadPool();

        // Crea los cuadrados, con tamaño y color aleatorios
        for (int i = 0; i < MAX_SQUARES; i++)
            squares.add(new Square(rand.nextInt(14) + 1, Integer.toHexString(rand.nextInt(0xFFFFFF)), new Point(rand.nextInt(14) + 1, rand.nextInt(14) + 1)));
        
        // Crea el hilo de la alfombra
        //System.out.println("TEST CREA ALFOMBRA");
        carpet = new Carpet(squares, "carpet.txt");
        es.execute(carpet);
        es.shutdown();
        
        //Se mantiene en un ciclo infinito hasta que todo el procesamiento haya terminado
        while (!es.awaitTermination(60, TimeUnit.SECONDS));
            //System.out.println("TEST...");
        
        //System.out.println("TEST TERMINO");
        
        //Imprime el area total
        System.out.println("AREA TOTAL: " + carpet.getAreaTotal());
    }
    
    /**
     * Main Function
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        test.ejecutar();
    }
    
}
