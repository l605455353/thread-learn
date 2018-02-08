package top.lfyao.thread.futureTask;

/**
 * 设计一个future简单实现
 * 上班前制作某产品，下班回来后取制作完成的产品
 * @author: mengJiangLi
 * @create: 2018-02-07 11:01
 **/
public class Demo {
    public static void main(String[] args){
        // 下单
        Future future = ProductFactory.createProduct("八宝粥");
        System.out.println("我去上班了，下了班我来取产品");

        // 拿着订单获取产品
        System.out.println("我拿着"+future.getProduct()+"回家!" );
    }
}
