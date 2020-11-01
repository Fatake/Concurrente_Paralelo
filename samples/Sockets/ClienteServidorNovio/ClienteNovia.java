
import java.io.*;
import java.net.*; 
import java.util.Scanner;
class ClienteNovia extends Thread{
  
static final String HOST = "localhost"; 
private String novia;
private Socket skCliente;
static final int Puerto=9009;
int cont=0;
boolean enamorada=true;
public ClienteNovia(String girlfriend ) {
	novia=girlfriend;
	
	

}
public void run(){
	
	while (enamorada)	
		try{
			skCliente = new Socket( HOST , Puerto ); 
		       
		       InputStreamReader in= new InputStreamReader(System.in);
		       Scanner s=new Scanner(in);
		       
		       System.out.println("que mensaje dejas a tu novio");
		       String mensaje=s.nextLine();
		      skCliente.setSendBufferSize(10000);
		       OutputStream aux =skCliente.getOutputStream(); 
		    		  
		    		   
		       DataOutputStream flujo= new DataOutputStream( aux ); 
		       flujo.writeUTF( "Hola amorcito soy "+novia + " "+mensaje ); 
		       if (cont>100000)
		    	     enamorada=false;
		       cont++;
		} catch( Exception e ) {
		System.out.println( e.getMessage() );
		} 
		try{
		skCliente.close();
		} catch( Exception e ) {
		System.out.println( e.getMessage() );
		} 
}
public static void main( String[] arg ) { 
	if (arg.length>0)
	new ClienteNovia(arg[0]).start();
} }