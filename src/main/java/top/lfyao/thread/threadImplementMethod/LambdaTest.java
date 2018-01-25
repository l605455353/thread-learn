package top.lfyao.thread.threadImplementMethod;

import java.util.Arrays;

import java.util.List;

/**
 * lambda表达式学习
 */
public class LambdaTest {
    public static void main(String[] args) {

        // 使用lambda表达式替换匿名类   () -> {}代码块替代了整个匿名类
        new Thread(() -> System.out.println("你好吗？")).start();
        // 使用lambda表达式对列表进行迭代
        List<String> list = Arrays.asList("one", "two", "threen");
//        list.forEach(i->System.out.println(i));
        list.forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------");

        // 类型声明
       MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;
        LambdaTest test = new LambdaTest();
        System.out.println("10 + 5 = " + test.operate(10, 5, addition));
        System.out.println("10 - 5 = " + test.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + test.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + test.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hi " + message);

        greetService1.sayMessage("你好");
        greetService2.sayMessage("good");


    }
    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
