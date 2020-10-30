public class Alumno implements Runnable{
    private String nombre;

    public Alumno (String nombre){
        super();
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println("Soy el alumno: "+this.nombre);
    }
}
