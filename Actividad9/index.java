import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Index {
    private PipedOutputStream pipeOut;
    private PipedInputStream pipeIn;
    private ExecutorService ejecutor;

    public Index(){ };

    public void init() throws InterruptedException{
        // Inicicia los Pipes
        pipeOut = new PipedOutputStream();

        try {
            pipeIn = new PipedInputStream(pipeOut);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("\nProblema al hacer link\n");
        }
        

        DataInputStream streamIn = new DataInputStream(pipeIn);
        DataOutputStream streamOut = new DataOutputStream(pipeOut);

        SecretariaA secre = new SecretariaA(streamOut,streamIn);
        Profesor profe = new Profesor("alverto",streamOut,streamIn);
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
