public class Rectangle extends GeometricObject {
    private double width;
    private double length;

    /**
     * 
     * @param color
     * @param filled
     * @param width
     * @param length
     */
    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }
    public Rectangle() {
        super();
        this.width = 1;
        this.length = 1;
    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }     
    public double getArea() {
        return width * length;
    }       
}