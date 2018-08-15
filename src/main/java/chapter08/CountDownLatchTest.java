package chapter08;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author benjaminChan
 * @date 2018/8/15 0015 上午 11:28
 */
public class CountDownLatchTest {

    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(7);
                    System.out.println(1);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t"){}.start();

        countDownLatch.await(6, TimeUnit.SECONDS);
        System.out.println(3);
    }
}