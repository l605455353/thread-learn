package top.lfyao.thread.threadImplementMethod;

/**
 * 匿名内部类的方式创建
 */
public class MethodThree {
    public static void main(String[] args){
        // 因为线程1的run重写了，原理见MethodTwo类中讲解的原理
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread-2 start ..");
            }
        }) {
            public void run() {
                System.out.println("thread-1 start ..");
            };
        }.start();



      /*  new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread runnning ...");
            }
        }).start();*/




    /*    new Thread() {
            public void run() {
                System.out.println("thread start ..");
            };
        }.start();*/

    }
}
