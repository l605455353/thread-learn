package top.lfyao.thread.threadCommunication.producterCustomerModel;

/**
 * 演示测试类
 *
 * @author: mengJiangLi
 * @create: 2018-02-02 16:27
 **/
public class ModelTest {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Producter producter = new Producter(shop);
        Customer customer = new Customer(shop);

        new Thread(producter).start();
        new Thread(producter).start();
        new Thread(producter).start();
        new Thread(producter).start();

        new Thread(customer).start();
        new Thread(customer).start();
        new Thread(customer).start();
        new Thread(customer).start();
    }
}
