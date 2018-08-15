package chapter05;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author benjaminChan
 * @date 2018/8/15 0015 上午 9:47
 */
public class ProcessData {
    private static final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private static final Lock readLock = rwl.readLock();
    private static final Lock writeLock = rwl.writeLock();
    private volatile boolean update = false;

    @Test
    public void processData() {
        readLock.lock();
        int i = 1/0;
        try{
            if (!update) {
                readLock.unlock();
                writeLock.lock();
                try{
                    if (!update) {
                        update = true;
                    }
                    readLock.lock();
                }finally {
                    writeLock.unlock();
                    System.out.println("writeLock unlock");
                }
            }
        }finally {
            readLock.unlock();
            System.out.println("readLock unlock");
        }
    }

}
