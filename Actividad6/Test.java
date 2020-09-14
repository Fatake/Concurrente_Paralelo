import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;



/**
 * Primer hilo en ejecutarse. Crea la lista de figuras {@link Square} y
 * el objeto de clase {@link Carpet}, al cual le pasa la lista creada.
 * Crea los dos hilos que se encargan tanto de calcular el área de calcular
 * el área de cada cuadrado como de almacenar en el archivo de la alfombra
 * la información de cada uno de ellos, respectivamente.
 * También contiene el método <code>main</code>.
 */

public class Test{
    private ExecutorService es;
    private Random rand;
    private Carpet carpet;
    private int areaTotal;

    public Test() throws InterruptedException {
        rand = new Random();
        ArrayList<Square> squares = new ArrayList<>();
        es = Executors.newCachedThreadPool();

        // Crea los cuadrados, con tamaño y color aleatorios
        for (int i = 0; i < MAX_SQUARES; i++)
            squares.add(new Square(rand.nextInt(14) + 1, Integer.toHexString(rand.nextInt(0xFFFFFF)), new Point(rand.nextInt(14) + 1, rand.nextInt(14) + 1)));
        
        // Crea el hilo de la alfombra
        System.out.println("TEST CREA ALFOMBRA");
        carpet = new Carpet(squares, "carpet.txt");
        es.execute(carpet);
        es.shutdown();
        
        while (!es.awaitTermination(60, TimeUnit.SECONDS))
            System.out.println("TEST...");
        
        System.out.println("TEST TERMINO");
        System.out.println("AREA TOTAL: " + carpet.getAreaTotal());
    }
    
    public static final int MAX_SQUARES = 10;

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
    }
    
}
