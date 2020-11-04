public class ejemplo2 implements Runnable{

    private static Monitor mon = new Monitor(20000);

    public ejemplo2(){

    }

    @Override
    public void run() {
        mon.incrementa();
        System.out.println(mon.getCont());
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
            hilos[i] = new Thread( new ejemplo2() );
            hilos[i].start();
        }

        for (int i = 0; i < hilos.length; i++) {
            try{
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Final: "+mon.getCont());
    }
}
