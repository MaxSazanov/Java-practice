package theory.multithreading.start;

public class Counter implements Runnable {
    private int counter;
    @Override
    public void run() {
        counter = 0;
        while (counter < 20) {
            ++counter;
            System.out.println(counter);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
