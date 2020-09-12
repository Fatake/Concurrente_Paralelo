public class DataWriter extends Thread {
    private final int squareID;
    private final Carpet carpet;

    public DataWriter(int squareID, Carpet carpet) {
        this.squareID = squareID;
        this.carpet = carpet;
    }

    @Override
    public void run() {
        try {
            carpet.writeToFile(squareID);
        }
        catch (InterruptedException ie) {
            
        }
    }
}
