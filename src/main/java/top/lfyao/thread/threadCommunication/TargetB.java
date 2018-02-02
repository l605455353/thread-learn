package top.lfyao.thread.threadCommunication;

/**
 * @author: mengJiangLi
 * @create: 2018-02-02 14:14
 **/
public class TargetB implements Runnable{
    private Demo demo;

    public TargetB(Demo demo) {
        this.demo = demo;
    }


    @Override
    public void run() {
        demo.get();
    }
}
