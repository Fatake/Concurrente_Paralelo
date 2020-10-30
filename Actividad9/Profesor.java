public class Profesor implements Runnable{
    private String nombre;
    public Profesor (String nombre){
        super();
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println("Soy el profesor: "+this.nombre);
    }
}
