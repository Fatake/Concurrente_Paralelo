
public class MonitorConVariable {
	private String hola="hola";
    private boolean esJefe;
	private String mundo="mundo";

	synchronized public void saludohola(String id,boolean soyJefe)

	{
		esJefe=soyJefe;
    while (!esJefe)
    {   try { wait();
    }catch (InterruptedException e) {System.err.println(e.getMessage());}
    
	System.out.println(hola+" "+ id);
    notify();
	}}

	synchronized public void saludomundo(String id, boolean soyJefe)

	{    esJefe=soyJefe;
		 while (!esJefe)
			    try { wait();
			    }catch (InterruptedException e) {System.err.println(e.getMessage());}
		 System.out.println(mundo+" "+ id);
		    notify();
					    

	}
}
