package top.lfyao.thread.threadCommunication.producterCustomerModel;

/**
 * 生产者类
 * @author: mengJiangLi
 * @create: 2018-02-02 16:25
 **/
public class Producter implements Runnable{
    private Shop shop;

    public Producter(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        while (true) {
            shop.push();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
