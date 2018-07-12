package concepts.timer.test;

public class TestThread implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Running + " + Thread.currentThread().getName());
    }
}
