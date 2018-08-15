package chapter06;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
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
                            String t = UUID.randomUUID().toString();
                            map.put(t, "");
                        }
                    }, "cm" + i).start();
                }
            }
        }, "cm");
        t.start();
        t.join();
        System.out.println(map.size());
    }


    /**
     * HashMap的扩容机制
     */
    @Test
    public void testMapCapacity() {
        Map<String, String> map = new HashMap<String, String>(2);
        map.put("1", "tom");
        map.put("2", "jerry");
        System.out.println(map.toString());
        map.put("3", "thomas");
        map.put("4", "fiona");
        System.out.println(map.toString());
        map.put("5", "benjamin");
        System.out.println(map.toString());
    }
}
