/**
 * Clase Objetos Geometricos
 */
public abstract class GeometricObject {
    private String color;
    private boolean filled;
    /***
     * Constructor
     * @param color
     * @param filled
     */
    public GeometricObject(String color, boolean filled) {
         super();
         this.color = color;
         this.filled = filled;
    }
    public GeometricObject() {
         super();
         this.color = "white";
         this.filled = false;
    }
    // accessors -----------------------
    public String getColor() {
         return color;
    }
    public void setColor(String color) {
         this.color = color;
    }
    public boolean getFilled() {
         return filled;
    }
    public void setFilled(boolean filled) {
         this.filled = filled;
    }
    // user-defined methods ------------
    public String showData() {
         return " Color: " + color
                   + " Filled: " + filled;
    }     
}