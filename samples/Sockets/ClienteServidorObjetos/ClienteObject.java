
import java.io.*;
import java.net.*; 
class ClienteObject {    
static final String HOST = "localhost"; static final int Puerto=5001;
public ClienteObject( ) {
try{   System.out.println("este es un cliente");
       Socket skCliente = new Socket( HOST , Puerto ); 
       OutputStream aux = skCliente.getOutputStream(); 
       PersonaNew persona=new PersonaNew(30,"Mirena","1");
       ObjectOutputStream flujo = new ObjectOutputStream( aux ); 
      
       flujo.writeObject(persona); 
       System.out.println("he mandado a una persona");
       skCliente.close();
} catch( Exception e ) {
System.out.println( e.getMessage() );
} }
public static void main( String[] arg ) { 
	new ClienteObject();
} }