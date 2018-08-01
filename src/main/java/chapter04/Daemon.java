package chapter04;

import java.util.concurrent.TimeUnit;

/**
 * Created by benjaminChan on 2018/8/1 0001 下午 5:31.
 *
 * Daemon 线程和主线程一起销毁
 */
public class Daemon {

    public static void main(String[] args) {
        Thread daemonThread = new Thread(new DaemonRunnable(), "DaemonRunnable");
        daemonThread.setDaemon(true);
        daemonThread.start();

        try {

        }finally {
            System.out.println("finally executes in necessarily?");
        }
    }

    private static class DaemonRunnable implements Runnable {
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                //finally里面的代码不一定会执行
                System.out.println("daemon finally run.");
            }
        }
    }
}
