import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Función principal Donde se generan los hilos
 */
public class SistemaSecretariaAcademica {
    public static void main(String args[]){
        ExecutorService exs = Executors.newCachedThreadPool();
        SecretariaAcademica sa = new SecretariaAcademica();
        Materia[] materias = sa.getMaterias();
        Random random = new Random();

        CountDownLatch cdlP = new CountDownLatch(5);
        Profesor[] p = new Profesor[]{
            new Profesor("Patricia Cervantes", generarMateriasDeseadas(materias, random.nextInt(3) + 1), sa, cdlP, random.nextInt(2) + 1),
            new Profesor("Hilda Castillo", generarMateriasDeseadas(materias, random.nextInt(4) + 1), sa, cdlP, random.nextInt(3) + 1),
            new Profesor("Meliza Contreras", generarMateriasDeseadas(materias, random.nextInt(4) + 1), sa, cdlP, random.nextInt(3) + 1),
            new Profesor("Ivan Olmos", generarMateriasDeseadas(materias, random.nextInt(3) + 1), sa, cdlP, random.nextInt(3) + 1),
            new Profesor("Beatriz Beltran", generarMateriasDeseadas(materias, random.nextInt(3) + 1), sa, cdlP, random.nextInt(2) + 1)
        }; 
        
        CountDownLatch cdlA = new CountDownLatch(6);
        Alumno[] a = new Alumno[]{
            new Alumno("Esiel", generarMateriasDeseadas(materias, random.nextInt(6) + 1), sa, cdlA, random.nextInt(5) + 1),
            new Alumno("Kevin", generarMateriasDeseadas(materias, random.nextInt(5) + 1), sa, cdlA, random.nextInt(5) + 1),
            new Alumno("Marco", generarMateriasDeseadas(materias, random.nextInt(4) + 1), sa, cdlA, random.nextInt(4) + 1),
            new Alumno("Antonio", generarMateriasDeseadas(materias, random.nextInt(5) + 1), sa, cdlA, random.nextInt(5) + 1),
            new Alumno("Paulo", generarMateriasDeseadas(materias, random.nextInt(6) + 1), sa, cdlA, random.nextInt(5) + 1),
            new Alumno("Cesar" , generarMateriasDeseadas(materias, random.nextInt(5) + 1), sa, cdlA, random.nextInt(5) + 1)  
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

    public static Materia[] generarMateriasDeseadas(Materia[] materias, int total){
        if (total <= 0 || total >= materias.length )
            return materias;
        
        ArrayList<Materia> materiasDeseadas = new ArrayList<Materia>(total);
        Random random = new Random();

        for (int i = 0 ; total > 0 && i < 5; i++){
            Materia materia = materias[random.nextInt(materias.length)];
            if (!materiasDeseadas.contains(materia)){
                materiasDeseadas.add(materia);
                total--;
                i = 0;
            }
        }
        return materiasDeseadas.toArray(new Materia[materiasDeseadas.size()]);
    }
}
