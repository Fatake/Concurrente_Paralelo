/**  
 *  Benemérita Universidad Autónoma de Puebla
 *  Programación Concurrente y Paralela
 *  Integrantes:
 *  Arizmendi Ramírez Esiel Kevin, 201737811
 *  Coria Rios Marco Antonio, 201734576
 *  Ruiz Lozano Paulo Cesar, 201734576
 */

/**
 * Hilo encargado de escribir la información de un cuadrado
 * de la alfombra en su archivo
 */

 public class DataWriter implements Runnable{
    
    private final Carpet carpet;
    private final int index;

    public DataWriter(Carpet carpet, int index) {
        this.carpet = carpet;
        this.index = index;
    }
    
    @Override
    public void run() {
        try {
            carpet.writeToFile(index);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
}
