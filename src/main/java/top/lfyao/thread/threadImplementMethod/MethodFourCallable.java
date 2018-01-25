package top.lfyao.thread.threadImplementMethod;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 带返回值的创建线程方式
 */
public class MethodFourCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
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
