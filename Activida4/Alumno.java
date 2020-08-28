/*  Benemérita Universidad Autónoma de Puebla
    Programación Concurrente y Paralela
    Integrantes:
        Arizmendi Ramírez Esiel Kevin
        Coria Rios Marco Antonio
        Ruiz Lozano Paulo Cesar
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
}