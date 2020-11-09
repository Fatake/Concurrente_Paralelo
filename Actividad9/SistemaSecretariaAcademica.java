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
            new Profesor("Patricia Cervantes", generarMateriasDeseadas(materias, random.nextInt(5) + 2), sa, cdlP, random.nextInt(3) + 2),
            new Profesor("Hilda Castillo", generarMateriasDeseadas(materias, random.nextInt(5) + 2), sa, cdlP, random.nextInt(4) + 2),
            new Profesor("Meliza Contreras", generarMateriasDeseadas(materias, random.nextInt(5) + 2), sa, cdlP, random.nextInt(4) + 2),
            new Profesor("Ivan Olmos", generarMateriasDeseadas(materias, random.nextInt(5) + 2), sa, cdlP, random.nextInt(4) + 2),
            new Profesor("Beatriz Beltran", generarMateriasDeseadas(materias, random.nextInt(5) + 2), sa, cdlP, random.nextInt(3) + 2)
        }; 
        
        CountDownLatch cdlA = new CountDownLatch(20);
        Alumno[] a = new Alumno[]{
            new Alumno("Esiel", generarMateriasDeseadas(materias, random.nextInt(6) + 3), sa, cdlA, random.nextInt(3) + 3),
            new Alumno("Kevin", generarMateriasDeseadas(materias, random.nextInt(5) + 3), sa, cdlA, random.nextInt(3) + 3),
            new Alumno("Marco", generarMateriasDeseadas(materias, random.nextInt(4) + 3), sa, cdlA, random.nextInt(3) + 3),
            new Alumno("Antonio", generarMateriasDeseadas(materias, random.nextInt(5) + 3), sa, cdlA, random.nextInt(3) + 3),
            new Alumno("Paulo", generarMateriasDeseadas(materias, random.nextInt(6) + 3), sa, cdlA, random.nextInt(3) + 3),
            new Alumno("Cesar" , generarMateriasDeseadas(materias, random.nextInt(5) + 3), sa, cdlA, random.nextInt(3) + 3),
            new Alumno("Angel", generarMateriasDeseadas(materias, random.nextInt(6) + 3), sa, cdlA, random.nextInt(3) + 3),
            new Alumno("Miguel", generarMateriasDeseadas(materias, random.nextInt(5) + 3), sa, cdlA, random.nextInt(3) + 3),
            new Alumno("Abigail", generarMateriasDeseadas(materias, random.nextInt(4) + 3), sa, cdlA, random.nextInt(3) + 3),
            new Alumno("Ariatna", generarMateriasDeseadas(materias, random.nextInt(5) + 3), sa, cdlA, random.nextInt(3) + 3),
            new Alumno("Quetzalli", generarMateriasDeseadas(materias, random.nextInt(6) + 3), sa, cdlA, random.nextInt(3) + 3),
            new Alumno("Misael" , generarMateriasDeseadas(materias, random.nextInt(5) + 3), sa, cdlA, random.nextInt(3) + 3),
            new Alumno("Alicia" , generarMateriasDeseadas(materias, random.nextInt(5) + 3), sa, cdlA, random.nextInt(3) + 3),
            new Alumno("Jazmín", generarMateriasDeseadas(materias, random.nextInt(6) + 3), sa, cdlA, random.nextInt(3) + 3),
            new Alumno("Elena", generarMateriasDeseadas(materias, random.nextInt(5) + 3), sa, cdlA, random.nextInt(3) + 3),
            new Alumno("María", generarMateriasDeseadas(materias, random.nextInt(4) + 3), sa, cdlA, random.nextInt(3) + 3),
            new Alumno("Andres", generarMateriasDeseadas(materias, random.nextInt(5) + 3), sa, cdlA, random.nextInt(3) + 3),
            new Alumno("Andrea", generarMateriasDeseadas(materias, random.nextInt(6) + 3), sa, cdlA, random.nextInt(3) + 3),
            new Alumno("Judas" , generarMateriasDeseadas(materias, random.nextInt(5) + 3), sa, cdlA, random.nextInt(3) + 3),
            new Alumno("Jesus" , generarMateriasDeseadas(materias, random.nextInt(5) + 3), sa, cdlA, random.nextInt(3) + 3)
        };
        
        System.out.println("||---------------------------- Asignación de Profesores ----------------------------||");
        //Profesores primero
        for (Profesor profesor : p){
            exs.execute(profesor);
        }
        try {
            cdlP.await();
            System.out.println("||------------------------- Fin de Asignación de Profesores -------------------------||");
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("||---------------------------- Inscripción de Alumnos ----------------------------||");
        //Alumnos despues
        for (Alumno alumno : a){
            exs.execute(alumno);
        }
        try {
            cdlA.await();
            System.out.println("||------------------------- Fin de Inscripción de Alumnos -------------------------||");
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("||---------------------------- Cursos ----------------------------||");
        for (Curso curso : sa.getCursos()){
            System.out.println(curso);
            System.out.println("||--------------------------------------------------------------||");
        }
        System.out.println("||------------------------- Fin de Cursos -------------------------||");
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
