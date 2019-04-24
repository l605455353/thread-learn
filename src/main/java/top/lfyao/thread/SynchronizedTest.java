package top.lfyao.thread;

public class SynchronizedTest {
    private static int number;


    public static void main(String[] args) {

//        test();
        testStatic();

    }

    /**
     * 锁类 测试
     */

    public static void testStatic() {
        SynchronizedTest test = new SynchronizedTest();
        createStaticThread("线程A");
        createThread("线程B", test);
    }

    /**
     * 锁实例对象 非静态方法 测试
     */
    public static void test() {

        SynchronizedTest test = new SynchronizedTest();
        createThread("线程A", test).start();
        createThread("线程B", test).start();

        // 多实例则存在线程安全
       /* SynchronizedTest b = new SynchronizedTest();
        createThread("线程C", b);*/

    }




    private static Thread createStaticThread(String name) {
        return new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + name + SynchronizedTest.nextStatic());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private static Thread createThread(String name,SynchronizedTest test) {
        return new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + name + test.next());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 锁非静态方法，锁的是实例对象   (比较加和不加synchronized 测试线程安全问题 )
    public  synchronized int next() {
        return number++;
    }

    public static int nextStatic() {
        return number++;
    }
}
