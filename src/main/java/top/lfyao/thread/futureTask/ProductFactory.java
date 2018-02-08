package top.lfyao.thread.futureTask;

import java.util.Random;

/**
 * @author: mengJiangLi
 * @create: 2018-02-07 10:53
 **/
public class ProductFactory {

    public static Future createProduct(String name) {
        // 创建一个订单
        Future future = new Future();
        System.out.println("下单成功，你可以去上班了");
        // 生产产品
        new Thread(()->{
            Product product = new Product(new Random().nextInt(1000), name);
            future.setProduct(product);
        }).start();
        return future;
    }
}
