
public class MainHilosconMonitorVariablesCondicion2 {
	
   
	public static void main ( String args[] )
    
	{
		boolean hilo1=false;
	    boolean hilo2=false;
		try {
	
	MonitorConVariable moni=new MonitorConVariable();
	Hilo1conMonitorVariable variosHilosVar1[]=new Hilo1conMonitorVariable[2];
	Hilo2conMonitorVariable variosHilosVar2[]=new Hilo2conMonitorVariable[2];
	
	for (int i=0; i<=1;i++){
	variosHilosVar1[i]=new Hilo1conMonitorVariable("Hilo1"+i,hilo1,moni);
	variosHilosVar1[i].start();
	
	hilo1=true;
	variosHilosVar2[i]=new Hilo2conMonitorVariable("Hilo2"+i,hilo2,moni);
	variosHilosVar2[i].start();
	
	hilo2=true;
	
	
	
	
		}
	variosHilosVar1[0].join();
	variosHilosVar2[0].join();
    variosHilosVar1[1].join();
    variosHilosVar2[1].join();
	
	
	
	System.out.println("Los hilos han terminado");
			
		}catch ( Exception e ){

	System.out.println ( e.toString() );
	}

}}