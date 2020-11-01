
public class MesaSemaforo {
	private int capacidad;
	private int platillosMesa;
	public MesaSemaforo() {
		
	};

	public  void agregarPlatilloMesa(String nombre) {
		System.out.println("soy el mesero "+nombre+" he colocado en la mesa un platillo ");
	}

	public void tomarPlatilloMesa( String nombre)  {
		// el comensal debe esperar que haya un platillo
		System.out.println("soy el comensal "+nombre+" he tomado de la mesa un platillo ");
	}
}
