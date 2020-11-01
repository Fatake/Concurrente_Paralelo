
public class MainHilosconMonitorVariablesCondicion {
	

	public static void main ( String args[] )

	{try {
	
	MonitorConVariable moni=new MonitorConVariable();
	Hilo1conMonitorVariable variosHilosVar1[]=new Hilo1conMonitorVariable[2];
	Hilo2conMonitorVariable variosHilosVar2[]=new Hilo2conMonitorVariable[2];
	
	for (int i=0; i<=1;i++){
	variosHilosVar1[i]=new Hilo1conMonitorVariable("Hilo1"+i,false,moni);
	variosHilosVar1[i].start();
	//variosHilosVar1[i].join();
	
	variosHilosVar2[i]=new Hilo2conMonitorVariable("Hilo2"+i,true,moni);
	variosHilosVar2[i].start();
	//variosHilosVar2[i].join();
	
			}
			
			System.out.println("Los hilos han terminado");
			
		}catch ( Exception e ){

	System.out.println ( e.toString() );
	}

}}