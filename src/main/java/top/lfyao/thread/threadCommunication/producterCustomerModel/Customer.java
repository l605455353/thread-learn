package top.lfyao.thread.threadCommunication.producterCustomerModel;

/**
 * 消费者类
 * @author: mengJiangLi
 * @create: 2018-02-02 16:26
 **/
public class Customer implements Runnable {
    private Shop shop;

    public Customer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        while (true) {
            shop.pull();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
