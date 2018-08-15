package chapter08;

import java.util.concurrent.CyclicBarrier;

/**
 * @author benjaminChan
 * @date 2018/8/15 0015 下午 1:54
 */
public class CyclicBarrierTest2 {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2,new Test());

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

    public static class Test implements Runnable {
        @Override
        public void run() {
            System.out.println("3");
        }
    }

}
