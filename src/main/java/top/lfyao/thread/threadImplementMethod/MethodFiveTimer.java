package top.lfyao.thread.threadImplementMethod;

import java.util.TimerTask;
import java.util.Timer;


/**
 * 定时器
 */
public class MethodFiveTimer {
    public static void main(String[] args){
        Timer timer = new Timer();
        // 间隔1秒执行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Thread running...");
            }
        },5000,5000);
        // delay 延迟
        // period 周期
    }
}
