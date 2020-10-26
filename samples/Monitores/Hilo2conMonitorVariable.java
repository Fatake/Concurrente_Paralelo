
public class Hilo2conMonitorVariable extends Thread {
	MonitorConVariable m;
	String id;
	boolean jefe;

	public Hilo2conMonitorVariable(String id,boolean soyJefe,MonitorConVariable m) {
		super(id);
		this.id = id;
		this.m = m;
		this.jefe = soyJefe;
	}

	public void run(){
		m.saludomundo(id+" soy jefe "+jefe,jefe);
	}
}
