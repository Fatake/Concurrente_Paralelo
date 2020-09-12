import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Carpet {
    private ArrayList<Square> squareList;
    private final String filename;
    private Semaphore sem;
    private FileWriter writer;

    public Carpet(ArrayList<Square> squareList, String filename) {
        this.squareList = squareList;
        this.filename = filename;

        sem = new Semaphore(1);
    }

    public boolean writeToFile(int index) throws InterruptedException {
        sem.acquire();
        try {
            File f = new File(filename);
            String content = "";
            if (f.length() != 0) content = new String(Files.readAllBytes(Paths.get(filename)));
            System.out.println("Wrote " + index);
            writer = new FileWriter(f);
            writer.write(content + squareList.get(index).toString() + "\n");
            writer.close();
            sem.release();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public int totalSurface() {
        int surface = 0;
        for (Square square : squareList) surface += square.getArea();
        return surface;
    }
}
