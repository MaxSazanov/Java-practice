package theory.multithreading.profiling;

public class Solution {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread = new Thread(counter, "counter");
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread finished");
    }
}

class Counter implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
