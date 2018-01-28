package top.lfyao.thread.lock;

import java.util.Random;

/**
 * 自旋锁
 * 多个线程执行完毕之后，打印一句话，结束
 *
 * 虚拟机会让当前想要获取锁的线程做几个空循环(这也是称为自旋的原因)，一般不会太久，可能是50个循环或100循环，在经过若干次循环后，
 * 如果得到锁，就顺利进入临界区。如果还不能获得锁，那就会将线程在操作系统层面挂起.
 */
public class SpinLok {

    public static void main(String[] args) {
        createThread().start();
        createThread().start();
        createThread().start();
        createThread().start();
        createThread().start();

        //当前线程数量不为1时 循环
        while (Thread.activeCount() != 1) {
            //自旋
        }
        System.out.println("all Thread ending");


    }

    private static Thread createThread() {
      return   new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "staring");
            try {
                Thread.sleep(new Random().nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"ending");

        });
    }
}


