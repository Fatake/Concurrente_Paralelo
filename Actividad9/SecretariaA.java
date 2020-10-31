import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
/**
 * Secretaria Accademica
 */
public class SecretariaA implements Runnable {
    private DataOutputStream out;
    private DataInputStream in;

    /**
     * Constructor secretaria academica
     * @param o -> output pipe
     * @param i -> intput pipe
     */
    public SecretariaA(DataOutputStream o, DataInputStream i ) {
        super();
        this.in = i;
        this.out = o;
    }

    @Override
    public void run() {
        try {
            this.out.writeChars("Hola soy la secre");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("\nProblema al escribir pipe\n");
        }
        System.out.println("Soy secretaria");
    }
}
