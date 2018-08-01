package chapter03;

/**
 * Created by benjaminChan on 2018/8/1 0001 下午 4:32.
 */
public class UnsafeLazyInitial {

    private static UnsafeLazyInitial unsafeLazyInitial;

    private UnsafeLazyInitial(){}

    public static UnsafeLazyInitial getInstance() {
        if (unsafeLazyInitial == null) {
            return new UnsafeLazyInitial();
        }
        return unsafeLazyInitial;
    }

    public static void main(String[] args) {
        UnsafeLazyInitial unsafeLazyInitial = UnsafeLazyInitial.getInstance();
        System.out.println(unsafeLazyInitial);
    }
}
