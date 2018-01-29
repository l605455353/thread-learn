package top.lfyao.thread.LockImplement;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 手写一个可重入的锁
 */
public class MyLock implements Lock {
    private boolean isLocked = false;
    //当前线程 (记录线程第一次进来）
    private Thread lockBy = null;
    // 计数器
    private int lockCount = 0;

    // 获取锁
    @Override
    public synchronized void lock() {


        Thread currentThread = Thread.currentThread();


        // 不能使用if判断
        while (isLocked && currentThread != lockBy)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        isLocked = true;
        lockBy = currentThread;
        lockCount++;
    }

    // 释放锁
    @Override
    public synchronized void unlock() {
        if (lockBy == Thread.currentThread()) {
            lockCount--;
            if (lockCount == 0) {
                isLocked = false;
                notify();
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }


    @Override
    public Condition newCondition() {
        return null;
    }
}
