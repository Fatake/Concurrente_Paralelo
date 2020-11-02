/**
     * Consumidor -> Tarta <- Productor
     * Consumidor:
     *  Si hay tarta le resta 1 a la variable
     *  si NO hay tarta despierta al productor y se duerme
     * 
     * Productor:
     *  Me duermo esperando a que me llamen
     *  Si me llaman produzco 10 trozos de tarta y me duermo
     */
public class ProductorConsumidor implements Runnable{
    private boolean consumidor;

    private static int tarta = 0;
    private static Object lock = new Object();

    public ProductorConsumidor(boolean consumidor){
        this.consumidor = consumidor;
    }

    @Override
    public void run(){

    }

    public static void main(String[] args) {
        int numHilos = 11;
        Thread[] hilos = new Thread[numHilos];

        for (int i = 0; i < hilos.length; i++) {
            Runnable runnable = null;
            if (i != 0) {
                runnable = new ProductorConsumidor(true);
            } else {
                runnable = new ProductorConsumidor(false);
            }
            hilos[i] = new Thread(runnable);
            hilos[i].start();
        }

        for (int i = 0; i < hilos.length; i++) {
            try{
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Soy hilo principal");
    }
}