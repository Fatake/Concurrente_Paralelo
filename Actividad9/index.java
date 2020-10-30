public class index {
    public static void main(String[] args) {
        SecretariaA secre = new SecretariaA();
        Profesor profe = new Profesor("alverto");
        Alumno alum = new Alumno("Juan");
        Thread ejecutor = new Thread(secre);
        
        ejecutor.start();
        ejecutor = new Thread(alum);
        ejecutor.start();
        ejecutor = new Thread(profe);
        ejecutor.start();
        
        System.out.println("Dame una botella de ron");
    }
}
