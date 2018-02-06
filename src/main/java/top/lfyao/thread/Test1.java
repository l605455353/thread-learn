package top.lfyao.thread;


import top.lfyao.thread.lock.Reentrant;

import javax.xml.parsers.DocumentBuilder;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {

    public static void main(String[] args){
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        Thread thread = new Thread();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}


