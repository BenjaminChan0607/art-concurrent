package chapter04;

import java.util.concurrent.TimeUnit;

/**
 * Created by benjaminChan on 2018/8/1 0001 下午 5:39.
 */
public class Join {

    public static void main(String[] args) {
        Thread preThread = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread joinThread = new Thread(new JoinRunnable(preThread), String.valueOf(i));
            joinThread.start();
            preThread = joinThread;
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " terminated");
    }

    private static class JoinRunnable implements Runnable {
        Thread thread;

        public JoinRunnable(Thread thread) {
            this.thread = thread;
        }

        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminated");
        }
    }
}
