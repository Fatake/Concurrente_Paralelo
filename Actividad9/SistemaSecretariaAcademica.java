import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SistemaSecretariaAcademica {
    public static void main(String args[]){
        ExecutorService exs = Executors.newCachedThreadPool();
        Materia[] materias = new Materia[]{
            new Materia("1","Metodología de la programación"),
            new Materia("2","Programación II"),
            new Materia("3","Estructura de Datos"),
            new Materia("4","Programación Concurrente y Paralela"),
            new Materia("5","Programación Distribuida Aplicada")
        };
        
        SecretariaAcademica sa = new SecretariaAcademica(materias);
        CountDownLatch cdlP = new CountDownLatch(3);
        Profesor[] p = new Profesor[]{
            new Profesor("Paty", new Materia[] {materias[0], materias[1], materias[2]}, sa, cdlP, 3),
            new Profesor("Hilda", new Materia[] {materias[1], materias[2], materias[3]}, sa, cdlP, 2),
            new Profesor("Meliza", new Materia[] {materias[2], materias[4]}, sa, cdlP, 2)
        }; 
        
        CountDownLatch cdlA = new CountDownLatch(6);
        Alumno[] a = new Alumno[]{
            new Alumno("Esiel", new Materia[] {materias[0], materias[1], materias[2]}, sa, cdlA, 2),
            new Alumno("Kevin", new Materia[] {materias[1], materias[2], materias[3]}, sa, cdlA, 3),
            new Alumno("Marco", new Materia[] {materias[2], materias[4]}, sa, cdlA, 2),
            new Alumno("Antonio", new Materia[] {materias[1], materias[0], materias[4]}, sa, cdlA, 2),
            new Alumno("Paulo", new Materia[] {materias[1], materias[0], materias[4]}, sa, cdlA, 2),
            new Alumno("Cesar" , new Materia[] {materias[2], materias[0], materias[3]}, sa, cdlA, 2)  
        };
        
        //Profesores primero
        for (Profesor profesor : p){
            exs.execute(profesor);
        }
        try {
            cdlP.await();
            System.out.println("TERMINARON LOS PROFESORES");
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        
        //Alumnos despues
        for (Alumno alumno : a){
            exs.execute(alumno);
        }
        try {
            cdlA.await();
            System.out.println("TERMINARON LOS ALUMNOS");
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        for (Curso curso : sa.getCursos()){
            System.out.println(curso);
        }
        
        
        
    }
    
}
