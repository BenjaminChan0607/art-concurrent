package chapter04;

import java.util.concurrent.TimeUnit;

/**
 * Created by benjaminChan on 2018/8/1 0001 下午 7:08.
 */
public class SleepUtils {

    public static void second(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
