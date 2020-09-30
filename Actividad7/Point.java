/**  
 *  Benemérita Universidad Autónoma de Puebla
 *  Programación Concurrente y Paralela
 *  Integrantes:
 *  Arizmendi Ramírez Esiel Kevin, 201737811
 *  Coria Rios Marco Antonio, 201734576
 *  Ruiz Lozano Paulo Cesar, 201734576
 */

/* 
* Ubica las coordenadas de cada cuadrado en la alfombra
*/

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
    
    
    
    
    
}
