package chapter02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by benjaminChan on 2018/8/1 0001 下午 3:40.
 *
 * volatile可以保证线程之间的可见性，不能保证线程的原子性
 */
public class Counter {

    private volatile int i = 0;
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        final Counter counter = new Counter();
        List<Thread> threadList = new ArrayList<Thread>(1000);
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        counter.count();
                        counter.atomicCount();
                    }
                }
            });
            threadList.add(thread);
        }

        for (Thread thread : threadList) {
            thread.start();
        }

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("i:" + counter.i);
        System.out.println("atomicInteger:" + counter.atomicInteger);
    }

    private void atomicCount() {
        for (; ; ) {
            int i = atomicInteger.get();
            boolean flag = atomicInteger.compareAndSet(i, ++i);
            if (flag) {
                break;
            }
        }
    }

    private void count() {
        i++;
    }
}
