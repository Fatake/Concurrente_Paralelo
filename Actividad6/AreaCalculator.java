public class AreaCalculator extends Thread {
    private final Test master;
    private final Square square;

    public AreaCalculator(Test master, Square square) {
        this.master = master;
        this.square = square;
    }

    @Override
    public void run() {
        int area = (int) Math.pow(square.getSideLength(), 2);
        square.setArea(area);

        // Notifica que su proceso ha terminado
        try {
            master.notifyFinish();
        }catch (InterruptedException ie) {
            System.err.println(ie.toString());
        }
    }
}
