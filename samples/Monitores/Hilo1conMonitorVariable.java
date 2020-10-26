
public class Hilo1conMonitorVariable extends Thread {
	MonitorConVariable m;
	String i;
	boolean jefe;

	public Hilo1conMonitorVariable(String i,boolean soyJefe,MonitorConVariable m){
		super(i);
		this.i = i;
		this.m = m;
		this.jefe = soyJefe;
	}

	public void run(){
		m.saludohola(i+" soy jefe "+jefe,jefe);
	}
}
