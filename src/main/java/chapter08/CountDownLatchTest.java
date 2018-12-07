package chapter08;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author benjaminChan
 * @date 2018/8/15 0015 上午 11:28
 *
 * CountDownLatch允许一个或多个线程等待其他线程完成操作
 * 如果CountDownLatch的构造参数N不为0时，await()方法会阻塞当前线程
 */
public class CountDownLatchTest {

    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(1);
                    TimeUnit.SECONDS.sleep(1);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1"){}.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }
        },"t2").start();

        System.out.println("await before;" + System.currentTimeMillis());
        countDownLatch.await();
        System.out.println("await after;" + System.currentTimeMillis());
        System.out.println(3);
    }

}