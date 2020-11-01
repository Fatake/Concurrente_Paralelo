
public class Hilo1conMonitor extends Thread {
	Monitor m;

	public Hilo1conMonitor(Monitor m){
		this.m = m;
	}

	public void run(){
		m.saludohola();
	}
}
