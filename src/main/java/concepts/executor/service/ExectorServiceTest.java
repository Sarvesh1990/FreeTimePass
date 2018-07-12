package concepts.executor.service;

import java.util.ArrayList;
import java.util.concurrent.*;

public class ExectorServiceTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        int n = 10;
        Future[] futures = new Future[n];

        for(int i = 0; i < n; i++) {
            futures[i] = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(1000);
                    return "Abc";
                }
            });
            System.out.println(futures[0].isDone()+ " " + System.currentTimeMillis());
            System.out.println("Waiting start"+ " " + System.currentTimeMillis());
            System.out.println(futures[0].get() + " " + System.currentTimeMillis());
            System.out.println(futures[0].isDone()+ " " + System.currentTimeMillis());
            System.out.println("Waiting over"+ " " + System.currentTimeMillis());
        }

    }
}
