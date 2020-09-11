/**
 * Clase Objetos Geometricos
 */
public abstract class GeometricObject {
    private String color;
    /***
     * Constructor
     * @param color
     * @param filled
     */
    public GeometricObject(String color) {
         super();
         this.color = color;
    }
    public GeometricObject() {
         super();
         this.color = "white";
    }
    // accessors -----------------------
    public String getColor() {
         return color;
    }
    public void setColor(String color) {
         this.color = color;
    }
    // user-defined methods ------------
    public String showData() {
         return " Color: " + color;
    }     
}