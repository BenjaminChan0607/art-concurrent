package chapter04;

import lombok.Data;

import java.util.Date;

/**
 * Created by benjaminChan on 2018/8/1 0001 下午 7:55.
 */
@Data
public class Profiler {

    private Date date;

    public static Profiler getInstance() {
        Profiler profiler = threadLocal.get();
        if (profiler == null) {
            profiler = new Profiler();
            threadLocal.set(profiler);
        }
        return profiler;
    }

    private static ThreadLocal<Profiler> threadLocal = new ThreadLocal<Profiler>();

    private Profiler() {

    }

    public static void begin() {
        getInstance().setDate(new Date());
    }

    public static long end() {
         return new Date().getTime() - getInstance().getDate().getTime();
    }

    public static void main(String[] args) {
        begin();
        SleepUtils.second(1);
        System.out.println(end());
    }

}
