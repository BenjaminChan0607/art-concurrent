package chapter08;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author benjaminChan
 * @date 2018/8/21 0021 下午 5:49
 *
 * 所有其他线程等待某一个线程的发生，某一个线程的数据依赖于之前线程的数据
 */
public class BankWaterService implements Runnable {

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this);
    private Executor executor = Executors.newFixedThreadPool(4);
    private ConcurrentMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    concurrentMap.put(Thread.currentThread().getName(), 1);
                    System.out.println(Thread.currentThread().getName());
                    try {
                        cyclicBarrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        // 汇总每个sheet计算出的结果
        for (Map.Entry<String, Integer> sheet : concurrentMap.entrySet()) {
            result += sheet.getValue();
        }
        concurrentMap.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
