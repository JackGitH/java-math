package com.dn.other;

public class Factorial {
    /**
     * @ClassName QuickSort
     * @Description TODO
     * @Author 郭洪昌
     * @Date 2019/11/19 10:48
     * @Version 1.0
     * N的阶乘
     */
    public static void main(String[] args) {
        System.out.println(getFac(5));
    }
    public  static int getFac( int n){
       if (n == 0){
           return  1;
       }
        return  n*getFac(n-1);
    }
}
