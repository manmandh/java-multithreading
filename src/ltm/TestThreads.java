package ltm;

class CountThread extends Thread {
    int pause; //

    CountThread(int pause) {
        this.pause = pause;
    }

    public void run() {
        int count = 0;
        while (true) {
            System.out.println(count++);
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class HelloThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("Hello!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class TestThreads {
    public static void main(String[] args) {
        CountThread t1 = new CountThread(2000);
        HelloThread t2 = new HelloThread();

        t1.start();
        t2.start();
    }
}
