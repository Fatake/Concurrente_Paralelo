/**
 * Clase alfombra
 */
public class Alfombra extends Thread {
    private GeometricObject [] objetos;

    /**
     * Constructor
     * @param objetos
     */
    public Alfombra(GeometricObject [] objetos) {
        this.objetos = objetos;
    }

    public void run() {
        System.out.println(getName() + " iniciando.");
        
    }
}
