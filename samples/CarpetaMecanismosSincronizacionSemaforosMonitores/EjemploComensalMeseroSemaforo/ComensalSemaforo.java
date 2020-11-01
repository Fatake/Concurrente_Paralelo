

public class ComensalSemaforo extends Thread{
	String nombre;
    MesaSemaforo m;
    MySemaphore mysem;

    public ComensalSemaforo(String nombre, MesaSemaforo mesita,MySemaphore sem){
        super(nombre);
    	this.nombre = nombre;
        this.m = mesita;
        mysem = sem;
    }
   
    public void run(){
		while(true) {
			System.out.println(nombre + " llego.");
			synchronized (mysem){      
				try {
					mysem.acquire();
					m.tomarPlatilloMesa( nombre);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}   
    }
}
