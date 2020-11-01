import java.io.* ;
import java.net.* ; 
class ServidorObject {
static final int PUERTO=5001; 
public ServidorObject( ) {
try {
ServerSocket skServidor = new ServerSocket(PUERTO); 
System.out.println("Escucho el puerto " + PUERTO ); 

    Socket skCliente = skServidor.accept(); // Crea objeto 
    System.out.println("he recibido un objeto"); 
    InputStream aux = skCliente.getInputStream(); 
    ObjectInputStream flujo= new ObjectInputStream( aux ); 
    
    PersonaNew p=(PersonaNew) flujo.readObject(); 
   
    System.out.println("Los datos son "+p);
    p.ponEdad(45);
    System.out.println(p.getNombre()+ " ha actualizado su edad "+p.getEdad());
    skCliente.close();


} catch( Exception e ) {
System.out.println( e.getMessage() ); }
}
public static void main( String[] arg ) {
new ServidorObject(); }
}
