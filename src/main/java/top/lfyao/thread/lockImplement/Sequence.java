package top.lfyao.thread.lockImplement;

/**
 *  *实现Lock的Demo
 */
public class Sequence {
    private MyLock lock =new MyLock();
    private int value;

    public int getNext() {
        lock.lock();
        value++;
        lock.unlock();
        return value;
    }
    public static void main(String[] args){
        Sequence sequence = new Sequence();
        createThread(sequence).start();
        createThread(sequence).start();
        createThread(sequence).start();
        // 锁重入测试
       /* new Thread(()->{
            new Sequence().getA();
        }).start();*/

    }

    private static Thread createThread(Sequence sequence) {
        return new Thread(()->{
            while (true)
            System.out.println(sequence.getNext());
        });
    }

    public void getA() {
        lock.lock();
        System.out.println("A");
        getB();
        lock.unlock();
    }

    public void getB() {
        lock.lock();
        System.out.println("B");
        lock.unlock();
    }
}
