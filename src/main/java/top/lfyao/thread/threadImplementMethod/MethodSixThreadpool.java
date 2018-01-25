package top.lfyao.thread.threadImplementMethod;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池实现
 */
public class MethodSixThreadpool {
    public static void main(String[] args){
        ExecutorService threadPool = Executors.newFixedThreadPool(10); //固定数量为10的线程池
//        Executor threadPool = Executors.newCachedThreadPool(); //不固定，根据当前任务，如果不够用就添加新的线程
        for (int i=0;i<1000;i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"Thread running");
                }
            });
        }

    }
}
