public class Monitor {
    private int cont = 0;
    private int order = 0;

    public Monitor(int size) {

    };

    public synchronized int incrementa(int size) {
        for (int i = 0; i < size; i++) {
            cont++;
        }
        return cont;
    }

    public synchronized void ordenar(int id) {
        // Se requiere una condicion de cuarda
        // condicion de concurso
        while (id != order) {
            // cerrojo.wait()
            try {
                wait();// van a una cola diferente al synchronized
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Si es tu turno
        System.out.println("soy el hilo "+id);
        order ++;
        notifyAll();
    }
}