package chapter03;

/**
 * Created by benjaminChan on 2018/8/1 0001 下午 4:34.
 */
public class SafeDoubleCheckLazyInitial {

    private static volatile SafeDoubleCheckLazyInitial safeDoubleCheckLazyInitial;

    private SafeDoubleCheckLazyInitial() {
    }

    public static SafeDoubleCheckLazyInitial getInstance() {
        if (safeDoubleCheckLazyInitial == null) {
            synchronized (SafeDoubleCheckLazyInitial.class) {
                if (safeDoubleCheckLazyInitial == null) {
                    safeDoubleCheckLazyInitial = new SafeDoubleCheckLazyInitial();
                }
            }
        }
        return safeDoubleCheckLazyInitial;
    }
}
