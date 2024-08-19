package ltm;

class DateRunnable implements Runnable {
    public void run() {
        while (true) {
            System.out.println(new java.util.Date());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MsgRunnable implements Runnable {
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

public class TestRunnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new DateRunnable());
        Thread t2 = new Thread(new MsgRunnable());

        t1.start();
        t2.start();
    }
}
