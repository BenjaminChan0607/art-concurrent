package chapter08;

import java.util.concurrent.CyclicBarrier;

/**
 * @author benjaminChan
 * @date 2018/8/15 0015 下午 1:54
 *
 * 让一
    组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会
    开门，所有被屏障拦截的线程才会继续运行。
 */
public class CyclicBarrierTest {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public static void main(String[] args) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            cyclicBarrier.await();
                        } catch (Exception e) {
                        }
                        System.out.println("1");
                    }
                }
        ){}.start();

        try {
            cyclicBarrier.await();
        } catch (Exception e) {

        }
        System.out.println("2");
    }
}
