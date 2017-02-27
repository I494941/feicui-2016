package com;

import java.util.Random;

/**
 * Created by 王金飞 on 2016/10/8.
 */
public class DoSomething {

    public static void main(String[] args) {
        System.out.println(DoSomething.doItNow(0));
        System.out.println(DoSomething.doItNow(10));
        System.out.println(DoSomething.doItNow(100));
        System.out.println(DoSomething.doItNow(1000));
    }

    public static int doItNow(int x) {
        int y = 0;
        Random o = new Random();
        float j = x / 2.0f;
        for (int i = 0; i < 1000; i++) {
            float k = o.nextFloat() * x - j;
            float z = o.nextFloat() * x - j;
            if (k * k + z * z <= j * j) {
                y++;
            }
        }
        return 4 * y / 1000;
    }

}
