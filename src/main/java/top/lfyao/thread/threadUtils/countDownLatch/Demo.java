package top.lfyao.thread.threadUtils.countDownLatch;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.jar.JarEntry;

/**
 * CountDownLatch（同步辅助类） 计数
 * 演示：
 * 1.多线程异步计算test.txt中每一行的总数
 * 2.等待每行都计算完后，算出所有行的总数
 *
 * @author: mengJiangLi
 * @create: 2018-02-06 14:48
 **/
public class Demo {
    private int[] test;

    public Demo(int line) {
        test = new int[line];
    }


    public static void main(String[] args) {
        // test.txt所有行的数据
        List<String> contexts = getContexts();
        // 行数
        int line = contexts.size();
        // CountDownLatch的构造函数接收一个int类型的参数作为计数器，如果你想等待N个点完成，这里就传入N
        CountDownLatch cdl = new CountDownLatch(line);

        Demo demo = new Demo(line);

        for (int i = 0; i < line; i++) {
            final int j = i;
            new Thread(() -> {
                demo.calculation(contexts.get(j), j, cdl);
            }).start();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        demo.sum();
    }

    // 计算总数
    public void sum() {
        System.out.println("汇总线程开始执行... ");
        int total = 0;
        for (int i = 0; i < test.length; i++) total += test[i];
        System.out.println("最终的结果为：" + total);
    }

    // 计算每一行的数字总和
    public void calculation(String line, int index, CountDownLatch countDownLatch) {
        String[] strings = line.split(",");
        int sum = 0;
        for (String string : strings) sum += Integer.parseInt(string);
        // 把计算的结果放到数组中指定的位置
        test[index] = sum;
        System.out.println(Thread.currentThread().getName() + " 执行计算任务... " + line + " 结果为：" + sum);
        countDownLatch.countDown();
    }

    private static List<String> getContexts() {
        List<String> contents = new ArrayList<>();
        String line = null;
        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader("src\\main\\java\\top\\lfyao\\thread\\threadUtils\\countDownLatch\\test.txt"));
            while ((line = br.readLine()) != null) contents.add(line);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return contents;
    }
}
