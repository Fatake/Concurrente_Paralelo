import Alumno.Rol;

/**
 * Clase mi Hilo
 */
public class MiHilo extends Thread{
    private final Alumno[] alumnos;

    /**
     * Constructor
     * 
     * @param nombre
     */
    public MiHilo(final Alumno[] alumnos) {
        this.alumnos = alumnos;
    }

    /**
     * //Punto de entrada del hilo
     */
    public void run() {
        System.out.println(getName() + " iniciando.");
        // Como ExtendThread extiende de Thread, puede llamar directamente
        // a todos los métodos de Thread, incluido el método getName().
        try {
            for (int i = 0; i < this.alumnos.length; i++) {
                Thread.sleep(5);
                System.out.println("" + alumnos[i]);
            }
        } catch (final InterruptedException exc) {
            System.out.println(getName() + " interrumpido.");
        }
        System.out.println(getName() + " finalizando.");
    }

    /**
     * Main
     * 
     * @param args
     */
    public static void main(final String args[]) {
        /*
         * rizmendi Ramírez Esiel Kevin, 2017 Coria Rios Marco Antonio, 201734576 Ruiz
         * Lozano Paulo Cesar, 2017
         */
        final Alumno alumo1 = new Alumno("Marco", "Coria", "Rios", 2017, Alumno.Rol.PROGRMADOR);
        final Alumno alumo2 = new Alumno("Esiel", "Rizmendi", "Ramirez", 201734576, Alumno.Rol.PROGRMADOR);
        final Alumno alumo3 = new Alumno("Paulo", "Ruiz", "Lozano", 201727952, Alumno.Rol.PROGRMADOR);

        final Alumno[] lista = { alumo1, alumo2, alumo3 };
        final MiHilo miHilo = new MiHilo(lista);
        miHilo.start();
	}
}