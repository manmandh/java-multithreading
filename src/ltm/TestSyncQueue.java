package ltm;
import java.util.Vector;
class SynchQueue {
    private Vector<Integer> queue = new Vector<>();
    private final int SIZE = 10;
    public synchronized void put(int item) throws InterruptedException {
        while (queue.size() == SIZE) {
            wait();
        }
        queue.add(item);
        notifyAll();
    }
    public synchronized int get() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int item = queue.remove(0);
        notifyAll();
        return item;
    }
}
class Producer extends Thread {
    private SynchQueue queue;
    Producer(SynchQueue queue) {
        this.queue = queue;
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                queue.put(i);
                System.out.println("Produced: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private SynchQueue queue;

    Consumer(SynchQueue queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                int item = queue.get();
                System.out.println("Consumed: " + item);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class TestSyncQueue {
    public static void main(String[] args) {
        SynchQueue queue = new SynchQueue();
        new Producer(queue).start();
        new Consumer(queue).start();
    }
}

