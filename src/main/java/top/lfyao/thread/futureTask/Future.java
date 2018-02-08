package top.lfyao.thread.futureTask;

/**
 * @author: mengJiangLi
 * @create: 2018-02-07 10:53
 **/
public class Future {
    private Product product;
    // 标识
    private boolean flag;

    public synchronized Product getProduct() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return product;
    }

    public synchronized void setProduct(Product product) {
        if (flag) return;
        this.product = product;
        this.flag = true;
        notifyAll();
    }
}
