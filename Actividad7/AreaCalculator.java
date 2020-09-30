
/**  
 *  Benemérita Universidad Autónoma de Puebla
 *  Programación Concurrente y Paralela
 *  Integrantes:
 *  Arizmendi Ramírez Esiel Kevin, 201737811
 *  Coria Rios Marco Antonio, 201734576
 *  Ruiz Lozano Paulo Cesar, 201734576
 */

/* 
* Hilo encargado de calcular un el area de un cuadrado de la alfombra
* y añade dicha area al area total
*/
public class AreaCalculator implements Runnable{
    
    private final Carpet carpet;
    private final int index;

    /**
     * Constuctor
     * @param carpet
     * @param index
     */
    public AreaCalculator(Carpet carpet, int index) {
        this.carpet = carpet;
        this.index = index;
    }

    @Override
    public void run() {
        carpet.addAreatTotal(index);
    }
}
