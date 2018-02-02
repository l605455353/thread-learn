package top.lfyao.thread.lockImplement;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁演示
 */
public class ReadWriteLockDemo {
    private Map<String,Object> map=new HashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock r = lock.readLock();
    private Lock w =lock.writeLock();

    // 读锁
    public Object get(String key) {
        r.lock();
        System.out.println(Thread.currentThread().getName()+"readLock starting");
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return map.get(key);
        }finally {
            r.unlock();
            System.out.println(Thread.currentThread().getName()+"readLock ending");
        }

    }
    //写锁
    public void put(String key, Object o) {
        w.lock();
        System.out.println(Thread.currentThread().getName()+"writeLock starting");
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, o);
        }finally {
            w.unlock();
            System.out.println(Thread.currentThread().getName()+"writeLock ending");
        }
    }

    private static Thread createThread(ReadWriteLockDemo readWriteLockDemo) {
        return new Thread(() -> {
            System.out.println(readWriteLockDemo.get("liu"));
        });

    }

    public static void main(String[] args){
        ReadWriteLockDemo demo = new ReadWriteLockDemo();
        demo.put("liu", "jiang");
        createThread(demo).start();
        createThread(demo).start();
        createThread(demo).start();
        createThread(demo).start();
        createThread(demo).start();
        new Thread(() -> {
            demo.put("wang", "hai");
        }).start();

    }
}
