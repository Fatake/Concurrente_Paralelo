
public class MainHiloParImparConSemaforo {
public static void main(String[] args) {
HiloParImparConSemaforo variosHilos[]=new HiloParImparConSemaforo[20];
MySemaphore sem=new MySemaphore();
for (int i=0; i<=19;i++){
variosHilos[i]=new HiloParImparConSemaforo(i,sem);
			variosHilos[i].start();
		}
		
		System.out.println("Los hilos han terminado");
		
	}
}
