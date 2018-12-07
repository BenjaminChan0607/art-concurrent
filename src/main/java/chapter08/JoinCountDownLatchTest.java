package chapter08;

import java.util.concurrent.TimeUnit;

/**
 * @author benjaminChan
 * @date 2018/8/15 0015 上午 11:11
 *  join用于让当前执行线程等待join线程执行结束(其他线程不会等待)。其实现原理是不停检查join线程是否存
    活，如果join线程存活则让当前线程永远等待。其中，wait（0）表示永远等待下去，代码片段如
    下。
    直到join线程中止后，线程的this.notifyAll()方法会被调用，调用notifyAll()方法是在JVM里
    实现的，所以在JDK里看不到，大家可以查看JVM源码。
 *
 */
public class JoinCountDownLatchTest {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ,"t1"){};
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2"){};

        t1.start();
        t2.start();

        System.out.println("t1.join() before:" + System.currentTimeMillis());
        t1.join();
        System.out.println("t1.join() after:" + System.currentTimeMillis());

        System.out.println("t2.join() before:" + System.currentTimeMillis());
        t2.join();
        System.out.println("t2.join() after:" + System.currentTimeMillis());
    }
}