package chapter06;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentPutMap {

    public static void main(String[] args) throws InterruptedException {
//        final HashMap<String, String> map = new HashMap<String, String>(2);
        final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>(2);//cpu消耗也是百分之百
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "cm" + i).start();
                }
            }
        }, "cm");
        t.start();
        t.join();
    }
}
