package chapter08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author benjaminChan
 * @date 2018/8/15 0015 上午 11:41
 *
 * semaphore(信号量) 控制访问特定资源的线程数量
 */
public class SemaphoreTest {

    private static final int THREAD_COUNT = 30;
    private static ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("operator," + finalI);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
    }

}
