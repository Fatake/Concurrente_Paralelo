
public class MeseroSemaforo extends Thread{
  String nombre;
  MesaSemaforo m;

  MySemaphore mysem;

  public MeseroSemaforo(String nombre, MesaSemaforo m,MySemaphore sem){
    super(nombre);
    this.nombre = nombre;
    this.m = m;
    mysem = sem;
  }  

  public void run(){
    while(true) {
      System.out.println(nombre + " llego.");

      synchronized (mysem){      
        mysem.release();
        m.agregarPlatilloMesa(nombre);
      }       
    } 
  }
}

