import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Carpet {
    private ArrayList<Square> squareList;
    private final String filename;
    private Semaphore sem;
    private FileWriter writer;

    public Carpet(ArrayList<Square> squareList, String filename) {
        this.squareList = squareList;
        this.filename = filename;

        sem = new Semaphore(1);

        writer = new FileWriter(filename);
    }

    public boolean writeToFile(int index) {
        sem.acquire();
        try {
            writer.write(squareList.get(index).toString() + "\n");
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
        sem.release();
    }

    public int totalSuface() {
        int surface = 0;
        for (Square square : squareList) surface += square.getArea();
        return surface;
    }
}
