package top.lfyao.thread.threadUtils.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier: 一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点
 * 演示：一群人开会 等待人都到齐了才开始会议
 * @author: mengJiangLi
 * @create: 2018-02-06 18:08
 **/
public class Demo {
    public void meeting(CyclicBarrier cb) {

        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()+ "到达会议室，等待开会");
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args){
        // 创建一个新的 CyclicBarrier，它将在给定数量的参与者（线程）处于等待状态时启动，并在启动 barrier 时执行给定的屏障操作，该操作由最后一个进入 barrier 的线程执行。
        // 注意 由最后一个线程执行
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10,new Thread(()->{
            System.out.println(Thread.currentThread().getName()+ "已到齐，会议开始。。。。。");
        }));
        Demo demo = new Demo();
        for (int i=0;i<10;i++) {
            new Thread(()->{
                demo.meeting(cyclicBarrier);
            }).start();
        }

    }
}
