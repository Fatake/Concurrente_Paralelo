/**  
 * Clase Mis Hilos
 *  Benemérita Universidad Autónoma de Puebla
 *  Programación Concurrente y Paralela
 *  Integrantes:
 *  Arizmendi Ramírez Esiel Kevin, 2017
 *  Coria Rios Marco Antonio, 201734576
 *  Ruiz Lozano Paulo Cesar, 2017
 */
public class MisHilos extends Thread {
    int lugar;
    private Alumno alumno;
    /**
     * Constructor
     * @param nombre
     * @param lugar
     * @param alumno
     */
    public MisHilos(String nombre,int lugar,final Alumno alumno){
        //super se usa para llamar a la versiÃ³n del constructor de Thread
        super(nombre);
        this.lugar = lugar;
        this.alumno = alumno;
    }
    
    /**
     * Run Thread
     */
    public void run(){
        System.out.println(getName()+" iniciando.");
        //Como ExtendThread extiende de Thread, puede llamar directamente 
        //a todos los mÃ©todos de Thread, incluido el mÃ©todo getName().
        try {
            Thread.sleep(5*lugar);
            System.out.println("" + alumno);
        }catch (InterruptedException exc){
            System.out.println(getName()+ " interrumpido.");
        }
            System.out.println(getName()+ " finalizando.");
    }
    public static void main(String args[]){
        Alumno[] alumnos = new Alumno[] {
            new Alumno("Marco Antonio", "Coria", "Rios", 201734576, new Alumno.Rol[] {Alumno.Rol.LIDER, Alumno.Rol.PROGRAMADOR}),
            new Alumno("Esiel Kevin", "Arizmendi", "Ramírez", 201737811, new Alumno.Rol[] {Alumno.Rol.DISEÑADOR, Alumno.Rol.PROGRAMADOR}),
            new Alumno("Paulo Cesar", "Ruiz", "Lozano", 201727952, new Alumno.Rol[] {Alumno.Rol.TESTER, Alumno.Rol.PROGRAMADOR})
        };

        MisHilos misHilos[] = new MisHilos[3]; 
        misHilos[0] = new MisHilos("primero",1,alumnos[0]);
        misHilos[1] = new MisHilos("segundo",2,alumnos[1]);
        misHilos[2] = new MisHilos("tercero",3,alumnos[2]);
        misHilos[0].start();
        misHilos[1].start();
        misHilos[2].start();
    }
}