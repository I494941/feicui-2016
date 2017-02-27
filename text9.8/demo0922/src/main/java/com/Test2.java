package com;


import java.util.Scanner;

/**
 * Created by 王金飞 on 2016/10/8.
 */
public class Test2 {

    int num = 0;

    public  int  fib(int index) {

        if(index == 0 ){
            return num =  0;
        }
        else if(index == 1){
            return num = 1;
        }
        else if(index == 2){
            return num = 1;
        }
        else{
            num = fib(index-1)+fib(index-2);

        }
            return num;

    }


    public static void main(String[] args) {

        System.out.println("请输入：");

        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();


        int[] list = new int[50];

        Test2 t = new Test2();

        list[input] = t.fib(input);

        System.out.println("list["+input+"] = "+ list[input]);


    }


}
