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
