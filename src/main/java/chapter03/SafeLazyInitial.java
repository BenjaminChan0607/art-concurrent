package chapter03;

/**
 * Created by benjaminChan on 2018/8/1 0001 下午 4:54.
 *
 * 加锁太重了
 */
public class SafeLazyInitial {

    private static SafeLazyInitial safeLazyInitial;

    private SafeLazyInitial(){}

    public static synchronized SafeLazyInitial getInstance() {
        if (safeLazyInitial == null) {
            safeLazyInitial = new SafeLazyInitial();
        }
        return safeLazyInitial;
    }
}
