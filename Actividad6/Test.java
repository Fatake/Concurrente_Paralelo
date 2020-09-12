import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;


/**
 * Primer hilo en ejecutarse. Crea la lista de figuras {@link Square} y
 * el objeto de clase {@link Carpet}, al cual le pasa la lista creada.
 * Crea los dos hilos que se encargan tanto de calcular el área de calcular
 * el área de cada cuadrado como de almacenar en el archivo de la alfombra
 * la información de cada uno de ellos, respectivamente.
 * También contiene el método <code>main</code>.
 */

public class Test extends Thread {
    private Random rand;
    private Semaphore sem;
    private int count;

    public Test() {
        rand = new Random();
        sem = new Sempahore(1);
        count = 10;
    }

    @Override
    public void run() {
        ArrayList<Square> squares = new ArrayList<>();

        // Crea los cuadrados, con tamaño y color aleatorios
        for (int i = 0; i < MAX_SQUARES; i++) {
            squares.add(new Square(rand.nextInt(14) + 1, Integer.toHexString(rand.nextInt(0xFFFFFF)), i));
        }

        // Crea la alfombra
        Carpet carpet = new Carpet(squares, "carpet.txt");

        // Crea los hilos para el procesamiento
        for (int i = 0; i < MAX_SQUARES; i++) {
            AreaCalculator calc = new AreaCalculator(squares.get(i));
            DataWriter writer = new DataWriter(i, carpet);

            calc.start();
            writer.start();
        }

        // Espera a que los hilos terminen y muestra el resultado
        while (count != 0) {
            sleep(200);
        }

        // Calcula el área total de la alfombra y la imprime en pantalla
        System.out.println("Área total de la alfombra: " + carpet.totalSurface());
    }

    public void notifyFinish() {
        sem.acquire();
        count--;
        sem.release();
    }

    public static final int MAX_SQUARES = 10;

    public static void main(String[] args) {
        Test test = new Test();
        test.start();
    }
}
