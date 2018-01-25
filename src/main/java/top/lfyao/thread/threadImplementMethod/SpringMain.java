package top.lfyao.thread.threadImplementMethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMain {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        MethodSevenSpring spring = ac.getBean(MethodSevenSpring.class);
        spring.one();
        spring.two();

    }
}
