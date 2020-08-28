/**  
 * Clase Mi Hilo
 *  Benemérita Universidad Autónoma de Puebla
 *  Programación Concurrente y Paralela
 *  Integrantes:
 *  Arizmendi Ramírez Esiel Kevin, 2017
 *  Coria Rios Marco Antonio, 201734576
 *  Ruiz Lozano Paulo Cesar, 2017
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
         *  Arizmendi Ramírez Esiel Kevin, 201737811
         *  Coria Rios Marco Antonio, 201734576
         *  Ruiz Lozano Paulo Cesar, 201727952
         */
        Alumno[] alumnos = new Alumno[] {
            new Alumno("Marco Antonio", "Coria", "Rios", 201734576, new Alumno.Rol[] {Alumno.Rol.LIDER, Alumno.Rol.PROGRAMADOR}),
            new Alumno("Esiel Kevin", "Arizmendi", "Ramírez", 201737811, new Alumno.Rol[] {Alumno.Rol.DISEÑADOR, Alumno.Rol.PROGRAMADOR}),
            new Alumno("Paulo Cesar", "Ruiz", "Lozano", 201727952, new Alumno.Rol[] {Alumno.Rol.TESTER, Alumno.Rol.PROGRAMADOR})
        };

        MiHilo miHilo = new MiHilo(alumnos); 
        miHilo.start();
	}
}