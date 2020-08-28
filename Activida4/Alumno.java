/**  
 *  Benemérita Universidad Autónoma de Puebla
 *  Programación Concurrente y Paralela
 *  Integrantes:
 *  Arizmendi Ramírez Esiel Kevin, 2017
 *  Coria Rios Marco Antonio, 201734576
 *  Ruiz Lozano Paulo Cesar, 2017
 */
public class Alumno {
    public enum Rol {
        PROGRAMADOR {
            @Override
            public String toString(){
                return "Programador";
            }
        },
        LIDER {
            @Override
            public String toString(){
                return "Lider";
            }
        },
        TESTER {
            @Override
            public String toString(){
                return "Tester";
            }
        },
        DISEÑADOR {
            @Override
            public String toString(){
                return "Diseñador";
            }
        }
    }
    public final String nombre;
    public final String apellidoPaterno;
    public final String apellidoMaterno;
    public final int matricula;
    public final Rol[] roles;
    /**
     * Constructor
     * @param nombre
     * @param ap
     * @param am
     * 
     */
    public Alumno (String nombre, String ap, String am, int mat, Rol[] roles){
        this.nombre = nombre;
        this.apellidoPaterno = ap;
        this.apellidoMaterno = am;
        this.matricula = mat;
        this.roles = roles;
    }
    /**
     * To String
     */
    public String toString(){
        return this.nombre+" "+this.apellidoPaterno+" "+this.apellidoMaterno+" "+this.matricula;
    }
}