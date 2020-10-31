import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Profesor implements Runnable {
    private String nombre;
    private DataOutputStream output;
    private DataInputStream input;

    public Profesor (String nombre, PipedOutputStream pipeOutput, PipedInputStream pipeInput ) {
        super();
        this.nombre = nombre;
        // Inicicia los Pipes
        try{
            input = new DataInputStream(new PipedInputStream(pipeOutput));
            //output = new DataOutputStream(new PipedOutputStream(pipeInput));
        }
        catch (IOException e) { 
            e.printStackTrace();
            System.out.println("\nEn al inicio\n");
        }
    }
    

    @Override
    public void run() {
        try {
            String aux = input.readUTF();
            System.out.println("E leido :"+aux);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("\nProblema al leer pipe\n");
        }
        System.out.println("Soy el profesor: "+this.nombre);
    }
}
