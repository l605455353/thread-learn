package top.lfyao.thread.threadImplementMethod;

/**
 * 实现Runnable接口方式创建
 * 作为线程任务存在 源码原理：
 *          1.init方法 将methodTwo作为一个任务Target 给Thread中的变量target
 *          2.启动的时候调用run()，会去判断target是否为空，不为空调用target中的run方法
 */
public class MethodTwo  implements Runnable{

    @Override
    public void run() {
        while (true) {
            System.out.println("Thread running...");
        }
    }
    
    public static void main(String[] args){
        MethodTwo methodTwo = new MethodTwo();
        Thread thread = new Thread(methodTwo);
        thread.start();

    }
}
