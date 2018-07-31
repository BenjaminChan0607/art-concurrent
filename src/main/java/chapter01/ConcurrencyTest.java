package chapter01;

/**
 * Created by benjaminChan on 2018/7/31 0031 下午 5:29.
 * <p>
 * Thread.join();
 */
public class ConcurrencyTest {

    private static final long count = 1000000000L;

    public static void main(String[] args) throws InterruptedException {
        serial();
        concurrency();
    }

    private static void concurrency() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Thread thread = new Thread(new Runnable() {
            public void run() {
                int a = 0;
                for (int i = 0; i < count; i++) {
                    a++;
                }
                System.out.println("a:" + a);
            }
        });

        thread.start();

        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }

        thread.join();
        long endTime = System.currentTimeMillis();
        System.out.println("b:" + b + " duration:" + (endTime - startTime));
    }

    private static void serial() {
        long startTime = System.currentTimeMillis();

        int a = 0;
        for (int i = 0; i < count; i++) {
            a++;
        }
        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("a:" + a + " b:" + b + " duration:" + (endTime - startTime));
    }
}
