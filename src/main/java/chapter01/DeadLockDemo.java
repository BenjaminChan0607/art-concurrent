package chapter01;

/**
 * Created by benjaminChan on 2018/7/31 0031 下午 5:48.
 *
 * DeadLock
 */
public class DeadLockDemo {

    private static final String A = "A";
    private static final String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    public void deadLock() {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                synchronized (A) {
                    System.out.println("get lock A");
//                    try {
//                        System.out.println("get lock A");
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    /*synchronized (B) {
                        System.out.println("1");
                    }*/
                    System.out.println("release lock A");
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                synchronized (B) {
                    System.out.println("get lock B");
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
