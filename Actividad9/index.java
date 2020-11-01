import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.sql.SQLInvalidAuthorizationSpecException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Index {
    // Pipes
    private PipedOutputStream pipeOut;
    private PipedInputStream pipeIn;

    // Escritores de las pipes
    private ObjectOutputStream streamOut;
    private ObjectInputStream streamIn;

    private ExecutorService ejecutor;

    public Index(){ };

    public void init() throws InterruptedException{
        
        // Inicicia los Pipes
        pipeOut = new PipedOutputStream();
        try {
            pipeIn = new PipedInputStream(pipeOut);

            // Escritores de los pipes
            streamOut = new ObjectOutputStream(pipeOut);
            streamIn = new ObjectInputStream(pipeIn);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("\nProblema al hacer link\n");
        }

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
