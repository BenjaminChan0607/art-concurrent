package chapter05;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author benjaminChan
 * @date 2018/8/13 0013 下午 8:29
 */
public class Cache {

    private static final Map<String, Object> map = new HashMap<String, Object>();
    private static final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private static final Lock r = rwl.readLock();
    private static final Lock w = rwl.writeLock();

    public static final Object get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }

    public static final Object set(String key, Object obj) {
        w.lock();
        try {
            return map.put(key, obj);
        } finally {
            w.unlock();
        }
    }

    public static final void clear() {
        w.lock();
        try{
            map.clear();
        }finally {
            w.unlock();
        }
    }
}
