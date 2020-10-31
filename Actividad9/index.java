import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Index {
    private PipedOutputStream output;
    private PipedInputStream input;
    private ExecutorService ejecutor;

    public Index(){ };

    public void init() throws InterruptedException{
        // Inicicia los Pipes
        output = new PipedOutputStream();
        try {
            input = new PipedInputStream(output);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        SecretariaA secre = new SecretariaA(output,input);
        Profesor profe = new Profesor("alverto",output,input);
        Alumno alum = new Alumno("Juan");
        ejecutor = Executors.newFixedThreadPool(3);

        ejecutor.execute(secre);
        ejecutor.execute(profe);
        ejecutor.execute(alum);
        ejecutor.shutdown();
    }

    /**
     * Main 
     * @param args
     */
    public static void main(String[] args) {
        Index inicio = new Index();
        try {
            inicio.init();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Dame una botella de ron");
    }
}
