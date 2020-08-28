public class Alumno {
    public final String nombre;
    public final String apellidoPaterno;
    public final String apellidoMaterno;
    public final int matricula;
    public final String rol;//(programador,líder,tester,diseñador)
    /**
     * Constructor
     * @param nombre
     * @param ap
     * @param am
     */
    public Alumno (String nombre, String ap, String am, int mat, String rol){
        this.nombre = nombre;
        this.apellidoPaterno = ap;
        this.apellidoMaterno = am;
        this.matricula = mat;
        this.rol = rol;
    }
}