import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Secretaria Academica
 */
public class SecretariaA implements Runnable {
    private static final String FILE_NAME = "materias.txt";
    private DataOutputStream out;
    private DataInputStream in;

    private ArrayList<Materia> materias;

    private File archivo = null;
    private FileReader fr = null;
    private BufferedReader br = null;

    /**
     * Constructor secretaria academica
     * @param o -> output pipe
     * @param i -> intput pipe
     */
    public SecretariaA(DataOutputStream o, DataInputStream i ) {
        super();
        this.in = i;
        this.out = o;
        this.materias = new ArrayList<>(); 
    }

    @Override
    public void run() {
        try {
            this.out.writeInt(3333);
            System.out.println("E enviado el NRC:"+3333);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("\nProblema al escribir pipe\n");
        }
        System.out.println("Soy secretaria");
        leeArchivo();
        printMaterias();
    }

    /**
     * Lee el archivo Materias.txt
     * Retorna una lista de objetos materia
     * @return
     */
    private boolean leeArchivo(){
        try {
            archivo = new File (FILE_NAME);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea = br.readLine())!=null){
                this.materias.add(new Materia(linea));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try{                    
                if( null != fr ){   
                    fr.close();  
                }                  
            }catch (Exception e2){ 
                e2.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public void printMaterias(){
        for (Materia materia : materias) {
            System.out.println(materia.getName());
        }
    }
}
