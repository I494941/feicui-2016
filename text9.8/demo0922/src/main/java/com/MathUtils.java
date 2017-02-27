package com;

/**
 * Created by 王金飞 on 2016/10/8.
 */
public class MathUtils {

    public static void main(String[] args){


        System.out.println(MathUtils.round(MathUtils.sqrt(4.2f)));

    }

    public static float sqrt(float x) {
        float xhalf = 0.5f * x;
        int i = Float.floatToIntBits(x);
        i = 0x5f3759df - (i >> 1);
        x = Float.intBitsToFloat(i);
        x = x * (1.5f - xhalf * x * x);
        return 1.0f / x;
    }

    public static int round(float num) {
        if (num > 0) {
            return (int) (num + 0.5f);
        } else {
            return (int) (num - 0.5f);
        }


    }

}
