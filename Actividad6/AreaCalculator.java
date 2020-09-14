public class AreaCalculator implements Runnable{
    
    private final Carpet carpet;
    private final int index;

    public AreaCalculator(Carpet carpet, int index) {
        this.carpet = carpet;
        this.index = index;
    }
    

    @Override
    public void run() {
        carpet.addAreatTotal(index);
    }
    
}
