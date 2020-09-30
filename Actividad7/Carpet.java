import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**  
 *  Benemérita Universidad Autónoma de Puebla
 *  Programación Concurrente y Paralela
 *  Integrantes:
 *  Arizmendi Ramírez Esiel Kevin, 201737811
 *  Coria Rios Marco Antonio, 201734576
 *  Ruiz Lozano Paulo Cesar, 201734576
 */

/* 
* Crea los dos hilos que se encargan tanto de calcular el área de calcular
* el área de cada cuadrado como de almacenar en el archivo de la alfombra
* la información de cada uno de ellos, respectivamente, ambos de manera sincronizada.
*/
public class Carpet implements Runnable{
    private ExecutorService es;
    private ArrayList<Square> squareList;
    private final String filename;
    private PrintWriter writer;
    private int areaTotal;

    /**
     * Constructor
     * @param squareList
     * @param filename
     */
    public Carpet(ArrayList<Square> squareList, String filename) {
        this.squareList = squareList;
        this.filename = filename;
        es = Executors.newCachedThreadPool();
    }

    /**
     * Escritor a archivo, de forma sincrona para cada hilo
     * @param index
     * @return
     * @throws InterruptedException
     */
    public synchronized boolean writeToFile(int index) throws InterruptedException {
        try {
            File f = new File(filename);
            writer = new PrintWriter(new FileWriter(f, true));
            writer.println(squareList.get(index));
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    /**
     * Calculador de Area total
     * @param index
     */
    public synchronized void addAreatTotal(int index){
        this.areaTotal += squareList.get(index).getArea();
    }
    
    public int getAreaTotal(){
        return areaTotal;
    }
    
    /**
     * Ejecuta el hilo
     */
    @Override
    public void run() {
        for (int i = 0; i < squareList.size() ; i++){
            System.out.println("DATA WRITER " + i);
            es.execute(new DataWriter(this, i));
            System.out.println("AREA CALCULATOR " + i);
            es.execute(new AreaCalculator(this, i));
        }
        es.shutdown();
        try {
            while (!es.awaitTermination(60, TimeUnit.SECONDS))
                System.out.println("Carpet...");
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println("CARPET TERMINO");
    } 
}

