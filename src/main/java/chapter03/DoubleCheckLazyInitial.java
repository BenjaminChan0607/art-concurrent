package chapter03;

/**
 * Created by benjaminChan on 2018/8/1 0001 下午 4:36.
 *
 * 存在安全隐患
 */
public class DoubleCheckLazyInitial {

    private static DoubleCheckLazyInitial doubleCheckLazyInitial;

    private DoubleCheckLazyInitial(){}

    public static DoubleCheckLazyInitial getInstance() {
        if (doubleCheckLazyInitial == null) {
            synchronized (DoubleCheckLazyInitial.class) {
                if (doubleCheckLazyInitial == null) {
                    doubleCheckLazyInitial = new DoubleCheckLazyInitial();
                }
            }
        }
        return doubleCheckLazyInitial;
    }
}
