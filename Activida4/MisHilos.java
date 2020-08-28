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
    //Construye un nuevo hilo.
    MisHilos(String nombre,int lugar){
        //super se usa para llamar a la versiÃ³n del constructor de Thread
        super(nombre);
        this.lugar=lugar;
    }
    //Punto de entrada del hilo
    public void run(){
        System.out.println(getName()+" iniciando.");
        //Como ExtendThread extiende de Thread, puede llamar directamente 
        //a todos los mÃ©todos de Thread, incluido el mÃ©todo getName().
        try {
            for (int cont=0;cont<11;cont++){
                Thread.sleep(5*lugar);
                System.out.println("En "+getName()+ ", el recuento es "+cont);
            }
        }catch (InterruptedException exc){
            System.out.println(getName()+ " interrumpido.");
        }
            System.out.println(getName()+ " finalizando.");
    }
    public static void main(String args[]){ 
        MisHilos misHilos[]=new MisHilos[3]; 
        misHilos[0] = new MisHilos("primero",1);
        misHilos[1] = new MisHilos("segundo",2);
        misHilos[2] = new MisHilos("tercero",3);
        misHilos[0].start();
        misHilos[1].start();
        misHilos[2].start();
    }
}