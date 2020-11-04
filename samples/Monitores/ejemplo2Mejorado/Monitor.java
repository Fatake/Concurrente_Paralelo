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
    /**
     * Desventaja de cerrojos
     *  siempre provee de exclusion mutua
     *  Por lo tanto ejecutan operaciones de manera secuencia en 
     *  esa parte del codigo
     * 
     *  Comprobar si es el turno del hilo son pasos de mas
     * 
     *  Lo mejor es hacer buffer donde una parte es synchonizado pero entonces
     *  ya no seria un monitor
     *  Pero la ganancia de rendimiento es la mejor
     *  Formalmente todos los monitores los metodos publicos todos son sincronizados
     * 
     *  Casi nunca se usan 
     * 
     * Ventaja:
     *  Simplifica codigo
     *  Delega todo lo concurrente a una clase
     *  Es imposible que existan interbloqueos
     *  Permite hacer modulos separar codigo y hacerlo reutilizable 
     * 
     * @param id
     */
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