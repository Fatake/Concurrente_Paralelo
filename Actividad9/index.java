import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Index {
    private PipedOutputStream output;
    private PipedInputStream input;
    private ExecutorService ejecutor;

    public Index(){ };

    public void init() throws InterruptedException{
        // Inicicia los Pipes
        PipedInputStream pipeIn = new PipedInputStream();
        PipedOutputStream pipeOut = new PipedOutputStream();

        DataInputStream myIn = new DataInputStream(pipeIn);
        DataOutputStream myOut = new DataOutputStream(pipeOut);

        SecretariaA secre = new SecretariaA(myOut,myIn);
        Profesor profe = new Profesor("alverto",myOut,myIn);
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
