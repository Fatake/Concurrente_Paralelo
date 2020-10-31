import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Profesor implements Runnable {
    private String nombre;
    private DataInputStream in;
    private DataOutputStream out;

    public Profesor (String nombre, DataOutputStream o, DataInputStream i  ) {
        super();
        this.nombre = nombre;
        // Inicicia los Pipes
        this.in = i;
        this.out = o;
    }
    
    @Override
    public void run() {
        try {
            String aux = in.readUTF();
            System.out.println("E leido :"+aux);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("\nProblema al leer pipe\n");
        }
        System.out.println("Soy el profesor: "+this.nombre);
    }
}
