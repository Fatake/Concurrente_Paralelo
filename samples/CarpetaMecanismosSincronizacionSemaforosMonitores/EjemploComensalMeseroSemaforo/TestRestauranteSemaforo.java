
public class TestRestauranteSemaforo {
	public static void main(String args[]){ 
		MesaSemaforo mesita = new MesaSemaforo();
		MySemaphore mysem = new MySemaphore();
		ComensalSemaforo c2 = new ComensalSemaforo("Maria",mesita,mysem);
		MeseroSemaforo m = new MeseroSemaforo("Luis",mesita,mysem);
		m.start();	  
		c2.start();	
	}
}

