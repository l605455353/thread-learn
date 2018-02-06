package top.lfyao.thread.threadCommunication.threadLocal;

/**
 * @author: mengJiangLi
 * @create: 2018-02-06 10:35
 **/
public class ThreadLocalDemo {
    private ThreadLocal<Integer> count = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public int getNext() {
        Integer value = count.get();
        value++;
        count.set(value);
        return value;
    }

    public static void main(String[] args) {
        ThreadLocalDemo demo = new ThreadLocalDemo();
        createThread(demo).start();
        createThread(demo).start();
        createThread(demo).start();
    }

    private static Thread createThread(ThreadLocalDemo demo) {
       return new Thread(() -> {
           while (true) {
               System.out.println(Thread.currentThread().getName() + " " + demo.getNext());
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
    }
}
