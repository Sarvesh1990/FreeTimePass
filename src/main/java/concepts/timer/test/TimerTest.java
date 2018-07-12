package concepts.timer.test;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();

        Thread thread = new Thread(new TestThread());
        thread.run();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer task1 running " + Thread.currentThread().getName());
            }
        }, 1000, 1000);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer task2 running " + Thread.currentThread().getName());
            }
        }, 500, 1000);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer task3 running " + Thread.currentThread().getName());
            }
        }, 2000, 2000);
    }
}
