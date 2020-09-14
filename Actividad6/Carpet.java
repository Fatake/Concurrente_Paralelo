import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Carpet implements Runnable{
    private ExecutorService es;
    private ArrayList<Square> squareList;
    private final String filename;
    private PrintWriter writer;
    private int areaTotal;

    public Carpet(ArrayList<Square> squareList, String filename) {
        this.squareList = squareList;
        this.filename = filename;
        es = Executors.newCachedThreadPool();
    }

    synchronized public boolean writeToFile(int index) throws InterruptedException {
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
    
    public void addAreatTotal(int index){
        this.areaTotal += squareList.get(index).getArea();
    }
    
    public int getAreaTotal(){
        return areaTotal;
    }

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

