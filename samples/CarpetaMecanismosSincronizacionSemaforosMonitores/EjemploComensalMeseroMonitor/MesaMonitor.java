
public class MesaMonitor {
	private boolean hayplatillo;
	
	public MesaMonitor() {
		hayplatillo = false;
	}
	
	public synchronized void agregarPlatilloMesa( String nombre) {
		System.out.println("soy el mesero "+nombre+" he colocado en la mesa el platillo ");
		hayplatillo = true;
		notifyAll();
	}

	public synchronized void tomarPlatilloMesa( String nombre) throws InterruptedException {
		// el comensal debe esperar que haya un platillo
		while (!hayplatillo){
			wait();
		}
		System.out.println("soy el comensal "+nombre+" he tomado de la mesa el platillo ");		
	}
}
