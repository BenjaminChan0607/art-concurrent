package chapter04;

import java.util.Date;

/**
 * Created by benjaminChan on 2018/8/1 0001 下午 7:29.
 *
 * 线程内添加取消标记
 */
public class ShutDown {

    public static void main(String[] args) {
        Thread thread = new Thread(new ShutDownRunnable(), "first");
        thread.start();
        SleepUtils.second(1);

        thread.interrupt();

        ShutDownRunnable shutDownRunnable = new ShutDownRunnable();
        thread = new Thread(shutDownRunnable, "second");
        thread.start();
        SleepUtils.second(1);

        shutDownRunnable.cancel();
    }

    private static class ShutDownRunnable implements Runnable {

        private boolean flag = true;
        private int i = 0;

        public void run() {
            while (flag && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println(Thread.currentThread().getName() + "i:" + i + new Date().toString());
        }

        public void cancel() {
            flag = false;
        }
    }
}
