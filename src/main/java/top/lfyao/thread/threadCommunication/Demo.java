package top.lfyao.thread.threadCommunication;

import java.util.concurrent.TimeUnit;

/**
 * 线程通信
 *      1.wait() 和notify()必须放在同步代码块中执行
 *      2.notify 执行后，必须在此同步代码释放锁以后，叫醒的线程才开始竞争
 *
 * @author: mengJiangLi
 * @create: 2018-02-02 11:01
 **/
public class Demo {
    // 信号
    private volatile int signal;


    public static void main(String[] args) {
        // 简单线程间通信demo
//        simpleTest();

        Demo demo = new Demo();
        TargetA targetA = new TargetA(demo);
        TargetB targetB = new TargetB(demo);

        new Thread(targetB).start();
        new Thread(targetB).start();
        new Thread(targetB).start();
        new Thread(targetB).start();

        try {

            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(targetA).start();

    }


    /**
     * @Description: 简单线程间通信demo
     * @param:
     * @return:
     * @Author: mengJiangLi
     * @Date: 2018/2/2
     */
    public static void simpleTest() {
        Demo demo = new Demo();
        new Thread(() -> {
            System.out.println("modify staring..........");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.setSignal(1);

            System.out.println("modify ending...........");
        }).start();
        new Thread(() -> {
            // 等待signal为1开始执行，否则不能执行
            while (demo.getSignal() != 1) {
                try {
                    Thread.sleep(1800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 当信号为1 的时候，执行代码
            System.out.println("模拟代码执行");
        }).start();
    }


    public synchronized int get() {
        System.out.println(Thread.currentThread().getName() + " 方法执行了...");
        if (signal != 1) {
            try {
                wait();
                System.out.println("叫醒之后");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 方法执行完毕...");
        return signal;
    }

    public synchronized void set() {
        this.signal = 1;
        // notify方法会随机叫醒一个处于wait状态的线程
        // notifyAll叫醒所有的处于wait线程，争夺到时间片的线程只有一个
        // notify();
        notifyAll();
        // notify 执行后，必须在此同步代码释放锁以后，叫醒的线程才开始竞争
        System.out.println("叫醒线程叫醒之后休眠开始....");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public int getSignal() {
        return signal;
    }

    public void setSignal(int signal) {
        this.signal = signal;
    }
}
