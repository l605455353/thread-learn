package top.lfyao.thread.LockImplement;

public class Main {
    private int value;
    private MyLock2 myLock2=new MyLock2();

    public int next() {
        myLock2.lock();
        value++;
        myLock2.unlock();
      return value;
    }
    public static void main(String[] args){
        Main main = new Main();
        new Thread(()->{
            while (true) {
                System.out.println(Thread.currentThread().getId()+" "+main.next());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true) {
                System.out.println(Thread.currentThread().getId()+" "+main.next());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
