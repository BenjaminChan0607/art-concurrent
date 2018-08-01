package chapter04;

import java.util.concurrent.TimeUnit;

/**
 * Created by benjaminChan on 2018/8/1 0001 下午 5:22.
 */
public class Interrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepRunnable(), "sleepThread");
        Thread busyThread = new Thread(new BusyRunnable(),"busyThread");

        //和主线程一起销毁
        sleepThread.setDaemon(true);
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(1);

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println(sleepThread.getClass().getSimpleName() + "," + sleepThread.isInterrupted());
        System.out.println(busyThread.getClass().getSimpleName() + "," + busyThread.isInterrupted());
    }

    private static class SleepRunnable implements Runnable {
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(2);//线程在沉睡，阻断不了
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class BusyRunnable implements Runnable {
        public void run() {
            while (true) {

            }
        }
    }
}
