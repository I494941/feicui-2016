package com;

/**
 * Created by 王金飞 on 2016/10/8.
 */
public class Test {

    private int i = getJ() ;
    private int j = 10;

    private int getJ(){
        return j;
    }
    public static void main(String[] args) {
        System.out.print(new Test().i);

    }
}
