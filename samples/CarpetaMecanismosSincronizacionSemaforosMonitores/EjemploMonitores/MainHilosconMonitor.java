import java.io.*;

public class MainHilosconMonitor {
	public static void main ( String args[] ){
		try {
		Monitor moni = new Monitor();
		Hilo1conMonitor proc1 = new Hilo1conMonitor (moni);
		Hilo2conMonitor proc2 = new Hilo2conMonitor (moni);

		proc1.start();
		proc2.start();

		proc1.join();
		proc2.join();
		}catch ( Exception e ){
			System.out.println ( e.toString() );
		}
	}
}

