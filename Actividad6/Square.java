public class Square {
    private int sideLength;
    private String color;
    private int position;
    private int area;

    public Square(int sideLength, String color, int position) {
        this.sideLength = sideLength;
        this.color = color;
        this.position = position;
        area = 0;
    }

    public int getSideLength() {
        return sideLength;
    }

    public String getColor() {
        return color;
    }

    public int getPosition() {
        return position;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Square #" + position + ", Side Length: " + sideLength + ", Color: #" + color;
    }
}
