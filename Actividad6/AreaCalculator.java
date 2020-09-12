public class AreaCalculator extends Thread {
    private final Test master;
    private final Square square;

    public AreaCalculator(Test mater, Square square) {
        this.master = master;
        this.square = square;
    }

    @Override
    public void run() {
        int area = Math.pow(square.getSideLength, 2);
        square.setArea(area);

        // Notifica que su proceso ha terminado
        master.notifyFinish();
    }
}
