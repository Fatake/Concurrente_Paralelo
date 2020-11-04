public class ejemplo2 implements Runnable{
    private int id;

    private static Monitor mon = new Monitor();

    public ejemplo2(int id){
        this.id = id;
    }

    @Override
    public void run() {
        int contador = mon.incrementa(2000);
        System.out.println(contador);

        mon.ordenar(id);
    }
    /**
     * Ejemplo 2 con monitores
     * @param args
     */
    public static void main(String[] args) {
        // Crea tantos hilos como procesadores logicos de la pc
        Runtime runtime = Runtime.getRuntime();
        // Si tienes 8 procesadores entonces generas 8 hilos
        int numHilos = runtime.availableProcessors();

        Thread[] hilos = new Thread[numHilos];

        for (int i = 0; i < hilos.length; i++) {
            Runnable runnable = new ejemplo2(i);
            hilos[i] = new Thread( runnable );
            hilos[i].start();
        }

        for (int i = 0; i < hilos.length; i++) {
            try{
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
