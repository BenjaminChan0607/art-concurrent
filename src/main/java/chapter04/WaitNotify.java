package chapter04;

import java.util.Date;

/**
 * Created by benjaminChan on 2018/8/1 0001 下午 7:04.
 */
public class WaitNotify {

    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) {
        Thread waitThread = new Thread(new WaitRunnable(), "Wait");
        Thread notifyThread = new Thread(new NotifyRunnable(), "Notify");

        waitThread.start();
        SleepUtils.second(1);

        notifyThread.start();
    }

    private static class WaitRunnable implements Runnable {
        public void run() {
            synchronized (lock) {
                while (flag) {
                    System.out.println("get lock,flag is true ,wait " + new Date().toString());
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("flag is false,running " + new Date().toString());
            }
        }
    }

    private static class NotifyRunnable implements Runnable {
        public void run() {
            synchronized (lock) {
                System.out.println("get lock,notify " + new Date().toString());
                lock.notifyAll();
                flag = false;
                SleepUtils.second(1);
            }
            synchronized (lock) {
                System.out.println("get lock again,sleep " + new Date().toString());
                SleepUtils.second(1);
            }
        }
    }
}
