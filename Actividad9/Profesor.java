import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Profesor implements Runnable {
    private String nombre;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public Profesor (String nombre, ObjectOutputStream o, ObjectInputStream i  ) {
        super();
        this.nombre = nombre;
        // Inicicia los Pipes
        this.in = i;
        this.out = o;
    }
    
    @Override
    public void run() {
        // Prueba recibir materias
        try {
            Materia aux2 = (Materia) this.in.readObject();
            System.out.println("Me inscribi en la materia: "+aux2.getName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("\nProblema al leer pipe\n");
        }
        System.out.println("Soy el profesor: "+this.nombre);
    }
}
