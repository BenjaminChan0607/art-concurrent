package chapter05;

import chapter04.SleepUtils;

import java.util.concurrent.locks.Lock;

/**
 * @author benjaminChan
 * @date 2018/8/13 0013 下午 12:43
 */
public class TwinsLockTest {

    public static void main(String[] args) {
        new TwinsLockTest().test();
    }

    public void test() {
        final Lock lock = new TwinsLock();
        class Worker extends Thread {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }
}
