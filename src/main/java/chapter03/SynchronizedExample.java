package chapter03;

/**
 * Created by benjaminChan on 2018/8/1 0001 下午 4:58.
 */
public class SynchronizedExample {

    private int i = 0;
    private boolean flag = false;

    public synchronized void write() {
        i = 1;
        flag = true;
    }

    public synchronized void read() {
        if (flag) {
            int t = i;
            System.out.println(t);
        }
    }
}
