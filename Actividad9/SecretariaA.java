import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
/**
 * Secretaria Accademica
 */
public class SecretariaA implements Runnable {
    private DataOutputStream output;
    private DataInputStream input;

    public SecretariaA(PipedOutputStream out, PipedInputStream inp ) {
        super();
        try{
            //input = new DataInputStream(new PipedInputStream(out));
            output = new DataOutputStream(new PipedOutputStream(inp));
        }
        catch (IOException e) { 
            e.printStackTrace();
            System.out.println("\nProblema al escribir pipe\n");
        }
    }

    @Override
    public void run() {
        try {
            this.output.writeChars("Hola soy la secre");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("\nProblema al escribir pipe\n");
        }
        System.out.println("Soy secretaria");
    }
}
