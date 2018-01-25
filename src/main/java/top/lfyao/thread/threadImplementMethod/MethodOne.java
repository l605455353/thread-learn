package top.lfyao.thread.threadImplementMethod;

/**
 * 法一：继承Thread类 创建线程
 * 中断线程 和守护线程 演示
 */
public class MethodOne extends Thread {

    public MethodOne(String name) {
        // 线程名字
        super(name);
    }

    @Override
    public void run() {
        //如果未被中断就执行
        while (!interrupted())
            System.out.println(getName() + "开始执行了");
    }

    public static void main(String[] args) throws InterruptedException {
//        daemonDemo();

        MethodOne methodOne = new MethodOne("1号线程");
        methodOne.start();
        Thread.sleep(1000);
        // 中断线程
        methodOne.interrupt();

    }


    /**
     * 呈现守护线程场景
     */
    private static void daemonDemo() throws InterruptedException {

        DaemonDemo methodOne = new DaemonDemo("1号线程");
        DaemonDemo methodOne2 = new DaemonDemo("2号线程");

        // 将此线程设置为守护线程  随着主线程的停止而停止
        methodOne.setDaemon(true);
        methodOne2.setDaemon(true);
        methodOne.start();
        methodOne2.start();

        Thread.sleep(1000);

    }


}

class DaemonDemo extends Thread {
    public DaemonDemo(String name) {
        // 线程名字
        super(name);
    }

    @Override
    public void run() {
        while (true)
            System.out.println(getName() + "开始执行了");
    }
}
