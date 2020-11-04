import java.util.Random;

public class pool implements Runnable{
    private static int tam = 8; // un hilo por fila de matriz
    private static int[][] matriz = new int[tam][tam];

    private int id;

    public pool(int id){
        this.id = id;
    }

    @Override
    public void run() {

    }
    /**
     * Ejemplo 2 con monitores
     * @param args
     */
    public static void main(String[] args) {
        Random rand = new Random(System.nanoTime());
        double timeStart, timeEnd;

        //Crea la matriz Inicial
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = rand.nextInt(10);
            }
        }

        timeStart = System.nanoTime();
        Thread[] hilos = new Thread[tam];
        
        // lanza a los hilos
        for (int i = 0; i < hilos.length; i++) {
            Runnable runnable = new pool(i);
            hilos[i] = new Thread( runnable );
            hilos[i].start();
        }

        // Espera a los hilos
        for (int i = 0; i < hilos.length; i++) {
            try{
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Checa los tiempos
        timeEnd = System.nanoTime() - timeStart;
        System.out.println("tiempo: "+(timeEnd/1000000));

        // imprime matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }
}
