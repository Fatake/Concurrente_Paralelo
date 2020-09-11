import java.util.Random;

/**
 * 
 */
public class Test{
    // Constante numero maximo de objetos
    public final static int NUM_OBJETOS = 10;
    // Arreglo de objetos
    private static Rectangle[] objetos;
    /**
     * Generador de objetos Rectangulo
     * @return
     */
    public Rectangle[] generaObjetos(){
        Rectangle[] obs = new Rectangle[NUM_OBJETOS];
        Random rand = new Random();
        
        for (int i = 0; i < NUM_OBJETOS; i++) {
            obs[i] = new Rectangle(getColor(), rand.nextInt(16), rand.nextInt(16));
        }
        return obs;
    }
    /**
     * Genera un color aleatoro
     * @return
     */
    private String getColor(){
        Random rand = new Random();
        switch ( rand.nextInt(7) ) {
            case 0:
                return "Azul";
            case 1:
                return "Rojo";
            case 2:
                return "Morado";
            case 3:
                return "Amarillo";
            case 4:
                return "Negro";
            case 5:
                return "Blanco";
        }
        return "Negro";
    }
    /**
     * Main
     * @param args
     */
    public static void main(String args[]){
        Test aux = new Test();
        objetos = aux.generaObjetos();
        
        System.out.println("Hola Mundo");
    }
}