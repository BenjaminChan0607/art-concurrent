package chapter08;

/**
 * @author benjaminChan
 * @date 2018/8/15 0015 上午 11:11
 */
public class JoinCountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + " finish");
                    }
                }
        ,"t1"){};
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " finish");
            }
        },"t2"){};

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(Thread.currentThread().getName() + " finish");
    }
}