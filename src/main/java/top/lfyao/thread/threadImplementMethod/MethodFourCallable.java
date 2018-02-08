package top.lfyao.thread.threadImplementMethod;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 带返回值的创建线程方式
 * Callalbe和runnable的区别：
 * runnable的run方法是被线程调用的，在run方法是异步执行的
 * callable的call方法，不是异步执行的，是由Future的run方法调用的
 */
public class MethodFourCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(10000);
        System.out.println("Thread running...");

        return 2;
    }

    public static void main(String[] args) throws Exception {
        MethodFourCallable mfc = new MethodFourCallable();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(mfc);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("do other thing");
        Integer result = futureTask.get();
        System.out.println("Thread result ="+result);

    }
}
