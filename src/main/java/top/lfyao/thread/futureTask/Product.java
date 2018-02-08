package top.lfyao.thread.futureTask;

/**
 * @author: mengJiangLi
 * @create: 2018-02-07 10:51
 **/
public class Product {
    private int id;
    private String name;

    public Product(int id, String name) {
        System.out.println("开始制作产品"+name);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.id = id;
        this.name = name;
        System.out.println(name+"产品制作完成");
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
