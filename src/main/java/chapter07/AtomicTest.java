package chapter07;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author benjaminChan
 * @date 2018/8/15 0015 上午 10:41
 */
public class AtomicTest {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    private static int[] value = new int[]{12, 13};
    private static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        testAtomicInteger();

        testAtomicIntegerArray();
    }

    private static void testAtomicIntegerArray() {
        System.out.println(atomicIntegerArray.get(0));
        System.out.println(atomicIntegerArray.get(1));

        System.out.println(atomicIntegerArray.getAndSet(0,3));
        System.out.println(atomicIntegerArray.get(0));
        System.out.println(value[0]);
    }

    private static void testAtomicInteger() {
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
    }
}
