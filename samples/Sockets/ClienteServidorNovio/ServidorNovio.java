
import java.io.* ;
import java.net.* ; 
import java.util.Scanner;
class ServidorNovio extends Thread{
static final int PUERTO=9009; 
/* este es un caso hipotetico los novios nunca tienen 
 * concurrentemente muchas novias :)
 */
public ServidorNovio( ) {

}
public void run(){
	try {
		ServerSocket skServidor = new ServerSocket(PUERTO); 
		System.out.println("Escucho el puerto " + PUERTO ); 
		while (true)
		{   Socket skCliente = skServidor.accept(); // Crea objeto 
		   System.out.println("Hola amor como estas "); 
		    InputStream aux = skCliente.getInputStream(); 
		    DataInputStream flujo = new DataInputStream( aux ); 
		    System.out.println( flujo.readUTF() ); 
		    skCliente.close();
		     }

		} catch( Exception e ) {
		System.out.println( e.getMessage() ); }
	
}
public static void main( String[] arg ) {
new ServidorNovio().start(); }
}
