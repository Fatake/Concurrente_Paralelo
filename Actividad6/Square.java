/**  
 *  Benemérita Universidad Autónoma de Puebla
 *  Programación Concurrente y Paralela
 *  Integrantes:
 *  Arizmendi Ramírez Esiel Kevin, 201737811
 *  Coria Rios Marco Antonio, 201734576
 *  Ruiz Lozano Paulo Cesar, 201734576
 */

/**
 * Clase que representa un cuadrado, asi como las coordenadas
 * correspondientes en la clase alfombra
 */
public class Square {
    private int sideLength;
    private String color;
    private Point position;

    /**
     * 
     * @param sideLength \n Tamaño
     * @param color \n color del cuadrado en la alfombra
     * @param position \n requiere de una clase punto
     */
    public Square(int sideLength, String color, Point position) {
        this.sideLength = sideLength;
        this.color = color;
        this.position = position;
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

