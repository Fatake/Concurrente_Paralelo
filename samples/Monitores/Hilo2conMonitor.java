
public class Hilo2conMonitor extends Thread {
	Monitor m;

	public Hilo2conMonitor(Monitor m) {

	this.m=m;

	}

	public void run(){

	m.saludomundo();

	}
}
