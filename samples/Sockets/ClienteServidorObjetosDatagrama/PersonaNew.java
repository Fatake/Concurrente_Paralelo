import java.util.Scanner;
import java.io.*;
public class PersonaNew implements Serializable{
private int edad;
private String nombre;
private String dni;
public PersonaNew(int ed,String nom,String d){
	
	edad=ed;
	nombre=nom;
	dni=d;
	}
public String getNombre(){return nombre;}
public String getDNI(){return dni;}
public int getEdad(){return edad;}

public void ponEdad(int edadNueva) throws Exception{
	
	if ((edadNueva<18)||(edadNueva>120) )
	
		// se lanza la excepci�n puesto que ha ocurrido un error
	  throw (new Exception("Edad no valida"));
	  edad=edadNueva;
	
}

public void verificaContra(String x) throws Exception{
	if(!x.equals("Susanita tiene un raton")){
		throw(new Exception("Password incorrecto"));
	}
}


public String toString(){
	return nombre+" tiene "+ edad+ " anios de edad y su id es " + dni;}
}
    