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
            obs[i] = new Rectangle("azul", rand.nextInt(16), rand.nextInt(16));
        }
        return obs;
    }
    public static void main(String args[]){
        Test aux = new Test();
        objetos = aux.generaObjetos();
        
        System.out.println("Hola Mundo"+);
    }
}