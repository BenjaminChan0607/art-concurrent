package chapter07;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author benjaminChan
 * @date 2018/8/15 0015 上午 10:58
 * <p>
 * CAS compare with pre value to decide whether or not to swap the newValue.
 */
public class AtomicReferenceTest {

    private static AtomicReference<User> atomicReference = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("tom", 24);
//        atomicReference.set(user);

        User updateUser = new User("jerry", 25);
        System.out.println(atomicReference.get());
        System.out.println(atomicReference.get() == user);
        atomicReference.compareAndSet(atomicReference.get(), updateUser);

        System.out.println(atomicReference.get().getName());
        System.out.println(atomicReference.get().getAge());
    }

    public static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
