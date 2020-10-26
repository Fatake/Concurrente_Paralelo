
public class MonitorConVariable {
	private String hola="hola";
    private boolean esJefe;
    private int jerarquiaJefe=2;
    private int jerarquiaSubordinado=2;
    private boolean ultimo=false;
	private String mundo="mundo";

	synchronized public void saludohola(String id,boolean soyJefe)

	{   
		//if (jerarquiaJefe>0)
			   esJefe=soyJefe;	 
						
    if (!esJefe)
	{  while (!esJefe)//sincronizacion jefe empleado
       {  
    	      try { 
    	  	  wait(); 
           }catch (InterruptedException e) {System.err.println(e.getMessage());}
        }
	  while (jerarquiaJefe>0)//sincronizacion de msg jefe
	  {      try {  
		     wait();
	         }catch (InterruptedException e) {System.err.println(e.getMessage());}
	  }
	  jerarquiaSubordinado--;
      System.out.println(hola+" "+ id);
      notifyAll();}
    
    else //si es jefe
    {  
    	 
    		
        if (jerarquiaJefe%2==0)
        { 
        	jerarquiaJefe--;
        	System.out.println(hola+" "+ id);
        	notifyAll();
        
        }
       
        	}
    }
	

	synchronized public void saludomundo(String id, boolean soyJefe)
{   
	//if (jerarquiaSubordinado>0)
	   esJefe=soyJefe;	 
	
	 if (!esJefe)	
	 {  while (!esJefe)
		   {    
		     try { 
		  
		    	 wait();   
		   }catch (InterruptedException e) {System.err.println(e.getMessage());}
		 }
	    while (jerarquiaJefe>0)
	    {     try { 
	    	       // notifyAll();
                wait();
	         }catch (InterruptedException e) {System.err.println(e.getMessage());}
	    }
	    while (jerarquiaSubordinado%2==0)
	    {    try {  
	    	       notifyAll();
	    	       ultimo=true;
               wait();
	         }catch (InterruptedException e) {System.err.println(e.getMessage());}
	    }
	    System.out.println(mundo+" "+ id);
	    jerarquiaSubordinado--;
	    notifyAll();
	}
	else //si es jefe
        {	
	//	 if (jerarquiaJefe%2==0)
	  //      	notifyAll();
	  	while (jerarquiaJefe%2==0)
		    try {  
		    	 notifyAll();
             wait();
		    }catch (InterruptedException e) {System.err.println(e.getMessage());}
        	   System.out.println(mundo+" "+ id);
        	   jerarquiaJefe=0;
        	   notifyAll();
        	 }
    
		
					    }
}