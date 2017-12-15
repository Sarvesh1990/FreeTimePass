package threads.thread.talk;

/**
 * Created by sarvesh on 31/10/17.
 */
public class Thread1 extends Thread{
    private Notifier notifier;

    public Thread1 (Notifier notifier) {
        this.notifier = notifier;
    }

    public void run() {
        notifier.printOdd();
    }
}
