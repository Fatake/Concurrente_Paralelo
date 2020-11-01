
public class MeseroMonitor extends Thread {
	String nombre;
    MesaMonitor m;

    public MeseroMonitor(String nombre, MesaMonitor m){
        super(nombre);
        this.nombre = nombre;
        this.m = m;
    }  
   
    public void run(){
        while (true){    
            System.out.println(nombre + " llego.");
            m.agregarPlatilloMesa( nombre);     
        }
    }
}
