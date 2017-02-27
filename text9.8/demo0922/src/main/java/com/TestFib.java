package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 王金飞 on 2016/10/8.
 */
public class TestFib {

    public static int  fib(int index1,int index2) {

        int fib = index1 + index2;

        return fib;
    }

    public static void main(String[] args) {

        System.out.println("请输入：");

        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        int[] list = new int[50];
        list[0] = 0;
        list[1] = 1;
        list[2] = 1;

        int index = 3;

        for(;index <= input;){

            list[index] =  TestFib.fib(list[index-1],list[index-2]);
            index++;
        }
        System.out.println(input);
        System.out.println(list[input]);

    }
}
