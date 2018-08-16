package chapter08;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author benjaminChan
 * @date 2018/8/15 0015 上午 11:28
 */
public class CountDownLatchTest {

    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(1);
                    countDownLatch.countDown();
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(2);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t"){}.start();

        long startTime = System.currentTimeMillis();
        countDownLatch.await(1, TimeUnit.SECONDS);
//        countDownLatch.await();//如果CountDownLatch的构造参数N不为0时，await()方法会阻塞当前线程
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(3);
    }

}