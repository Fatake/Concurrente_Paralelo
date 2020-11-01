


public class HiloParImparConSemaforo extends Thread{
	private final int id;
	private MySemaphore sem;
	
	public HiloParImparConSemaforo(int id,MySemaphore semaforo) { 
		this.setName(Integer.toString(id));
	    this.id=id;    
	    this.sem=semaforo;
	    }
	  
	  
	  
	    public void run() {
	int x=Integer.parseInt(Thread.currentThread().getName().toString());
		if ( x%2==0)
			try
	    {
			synchronized(sem){	
			sem.acquire();
			System.out.println("si estoy vivo veras este mensaje "+getName());
			System.out.println("mi tabla de multiplicar es");
			for (int i=1;i<=10;i++)
				System.out.println(i+" * "+x+"="+i*x);
			}
	    }catch(InterruptedException e) {System.out.println(e.getMessage());}
		else
			synchronized(sem){	
			sem.release();
			int cont=0;
			 for(int i=2;i<x;i++)
				 if (x%i==0)
					 cont++;
			 if (cont>0)
			   System.out.println(getName()+" no es primo");
			 else
			  System.out.println(getName()+" si es primo");
			 System.out.println("yo "+getName()+" he despertado a algun hilo no se a cual");
			 }
	
	 }
	}

