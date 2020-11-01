
public class TestRestauranteMonitor {
	public static void main(String args[]){ 
		MesaMonitor mesita = new MesaMonitor();
		ComensalMonitor c2 = new ComensalMonitor("Maria",mesita);
		MeseroMonitor m = new MeseroMonitor("Luis",mesita);

		m.start();	  
		c2.start();	
	}
}
