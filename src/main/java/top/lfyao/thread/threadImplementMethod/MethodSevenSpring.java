package top.lfyao.thread.threadImplementMethod;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * spring方式实现多线程
 */
@Service
public class MethodSevenSpring {
    @Async
    public void one() throws InterruptedException {
        while (true) {
            System.out.println(Thread.currentThread().getName()+"one running");
            Thread.sleep(1000);
        }
    }
    @Async
    public void two() throws InterruptedException {
        while (true) {
            System.out.println(Thread.currentThread().getName()+"two running");
            Thread.sleep(1000);
        }
    }
    
}
