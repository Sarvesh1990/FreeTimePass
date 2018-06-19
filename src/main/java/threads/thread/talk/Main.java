package threads.thread.talk;

/**
 * Created by sarvesh on 31/10/17.
 */
public class Main {
    public static void main(String[] args) {
        Notifier notifier = new Notifier();

        new Thread1(notifier).start();
        new Thread2(notifier).start();
        new Thread3(notifier).start();
    }
}
