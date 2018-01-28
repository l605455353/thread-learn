package top.lfyao.thread.lock;

/**
 * 死锁举例
 */
public class DeadLock {
    private Object a=new Object();
    private Object b=new Object();

    public void a() {
        synchronized (b) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (a) {
                System.out.println("A");
            }
        }
    }
    public void b() {
        synchronized (a) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (b) {
                System.out.println("B");
            }
        }
    }
    
    public static void main(String[] args){
        DeadLock deadLock = new DeadLock();
        new Thread(()->{
            deadLock.a();
        }).start();
        new Thread(()->{
            deadLock.b();
        }).start();
    }
}
