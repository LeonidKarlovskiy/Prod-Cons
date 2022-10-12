import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProdConsBQ {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> produce());
        Thread thread2 = new Thread(() -> consumer());


        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void produce() {
        Random random = new Random(100);
        while (true) {
            try {
                queue.put(random.nextInt(20));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private static void consumer() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(500);
                if (random.nextInt(10) == 5) {
                    System.out.println(queue.take());
                    System.out.println("Queue size is " + queue.size());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}