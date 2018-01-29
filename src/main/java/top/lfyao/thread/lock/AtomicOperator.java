package top.lfyao.thread.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 保证了原子性
 */
public class AtomicOperator {
    public static void main(String[] args){
        // 基本类型
        AtomicInteger value = new AtomicInteger();
        value.getAndIncrement();
        int[] i = {1, 5, 7, 0};
        // 数组
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(i);
        // 抽象类型
        AtomicReference<User> user = new AtomicReference<>();


    }

    private class User {
        private int age;
        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
