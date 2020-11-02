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
    private int id;

    private static int tarta = 0;
    private static int c = 1;
    private static Object lock = new Object();

    public ProductorConsumidor(boolean consumidor){
        this.consumidor = consumidor;
        if (consumidor) {
            this.id = c;
            c++;
        }
    }

    @Override
    public void run(){
        while (true) {
            if (consumidor) {
                consumir();
            } else { // Productor
                produce();
            }
        }
    }

    private void consumir(){
        synchronized (lock){
            if (tarta > 0) {
                tarta --;
                System.out.println("[C"+id+"] Me e comido una tarta, quedan "+tarta);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else { // ya no hay tartas
                lock.notifyAll(); // no se puede despertar a un hilo en concreto
                try { // me mimo
                    lock.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void produce(){
        synchronized (lock){ // la variable tarta es un recurso compartido
            if (tarta == 0) {
                tarta = 10;
                System.out.println("[P] Produzco "+tarta+" tartas");
                lock.notifyAll();// Despertar a todos los consumidores
            }
            // se duerme el productor
            try {
                lock.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Donde el hilo[0] es productor
     * los otros 10 hilos son consumidores
     * @param args
     */
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