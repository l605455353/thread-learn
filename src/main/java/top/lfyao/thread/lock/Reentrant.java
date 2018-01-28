package top.lfyao.thread.lock;

/**
 * 锁重入： 在获取当前实例对象锁后进入synchronized代码块执行同步代码，并在代码块中调用了当前实例对象的另外一个synchronized方法，
 * 再次请求当前实例锁时，将被允许，进而执行方法体代码
 */
public class Reentrant {

    public static void main(String[] args) {
        Reentrant reentrant = new Reentrant();
        Reentrant reentrant1 = new Reentrant();
        // 不同对象不能保证线程安全
        new Thread(() -> {
            reentrant.getA();
        }).start();
        new Thread(() -> {
            reentrant1.getB();
        }).start();

    }

    public synchronized void getA()  {
        while (true)
        System.out.println("A");
        //锁重入测试
//        getB();
    }

    public synchronized void getB()  {
        while (true)
        System.out.println("B");



    }
}
