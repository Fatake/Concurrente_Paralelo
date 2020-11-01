import java.io.Serializable;

public class Materia implements Serializable {
    private String nombre;
    private int nrc;


    public Materia (String nombre){
        this.nombre = nombre;    
    }

    public String getName(){
        return this.nombre;
    }
}
