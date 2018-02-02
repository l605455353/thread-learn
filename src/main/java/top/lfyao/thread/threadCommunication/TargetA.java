package top.lfyao.thread.threadCommunication;

/**
 * @author: mengJiangLi
 * @create: 2018-02-02 13:56
 **/
public class TargetA implements Runnable{

    private Demo demo;

    public TargetA(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        demo.set();
    }
}
