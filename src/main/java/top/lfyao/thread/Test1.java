package top.lfyao.thread;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test1 {

    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
        list.add(2);
        Vector vector = new Vector();

        //  elementData = Arrays.copyOf(elementData, newCapacity);

        int[] a = new int[2];
        a[0] = 10;
        a[1] = 11;
//        System.out.println(a[2]);

        System.out.println(a);
        a = Arrays.copyOf(a, 3);
        System.out.println(a);
        a[2] = 11;
        System.out.println(a);


        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();



    }


}


