package threads.thread.talk;

/**
 * Created by sarvesh on 31/10/17.
 */
public class Notifier {
    private Object monitor = new Object();
    private int count = 1;
    private boolean first = true;
    private boolean second = false;
    private boolean third = false;

    public void printEven() {
        synchronized (monitor) {
            while (count < 20) {
                System.out.println("Trying second");
                if(second) {
                    System.out.println("Print even : " + count);
                    count++;
                    second = false;
                    third = true;
                }
                monitor.notifyAll();
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            monitor.notify();
        }
    }

    public void printOdd() {
        synchronized (monitor) {
            while (count < 20 ) {
                System.out.println("Trying first");
                if(first) {
                    System.out.println("Print odd : " + count);
                    count++;
                    first = false;
                    second = true;
                }
                monitor.notifyAll();
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            monitor.notify();
        }
    }

    public void printThird() {
        synchronized (monitor) {
            while (count < 20) {
                System.out.println("Trying third");
                if(third) {
                    System.out.println("Print third : " + count);
                    count++;
                    third = false;
                    first = true;

                }
                monitor.notifyAll();
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            monitor.notify();
        }
    }
}
