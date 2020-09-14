public class Square {
    private int sideLength;
    private String color;
    private Point position;
    private int area;

    public Square(int sideLength, String color, Point position) {
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

    public Point getPosition() {
        return position;
    }

    public int getArea() {
        return (int) Math.pow(sideLength, 2);
    }

    @Override
    public String toString() {
        return "Square #" + position + ", Side Length: " + sideLength + ", Color: #" + color;
    }
}

