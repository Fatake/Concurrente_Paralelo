import java.util.Objects;

public class Materia {
    private final String clave;
    private final String nombre;
    
    /**
     * Construye una nueva {@code Materia} dada su clave y su nombre.
     * @param clave Clave de la materia
     * @param nombre Nombre de la materia
     */
    public Materia(String clave, String nombre){
        this.clave = clave;
        this.nombre = nombre; 
    }
    
    /**
     * Retorna la clave de esta materia.
     * @return la clave de esta materia
     */
    public String getClave(){
        return clave;
    }
    
    /**
     * Retorna el nombre de esta Materia.
     * @return el nombre de esta materia
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Compara esta materia con el objeto especificado.
     * @param obj objeto a comparar con esta {@code Materia}
     * @return {@code true} si el objeto dato representa una {@code Materia}
     *          equivalente a esta materia, {@code false} en cualquier otro caso.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Materia other = (Materia) obj;
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        return true;
    }
}
