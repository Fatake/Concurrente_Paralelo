
public class ComensalMonitor extends Thread {
	String nombre;
    MesaMonitor m;
    
         
   
    public ComensalMonitor(String nombre, MesaMonitor m){
       super(nombre);
      	this.nombre = nombre;
        this.m=m;
       
       
    }
   
    public void run(){
    while (true)  
    	{System.out.println(nombre + " llego.");
      
  
         try {
			m.tomarPlatilloMesa( nombre);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         } 
        }
}
