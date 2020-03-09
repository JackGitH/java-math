package com.dn.sort;

/**
 * @ClassName OrderSort
 * @Description TODO
 * @Author 郭洪昌
 * @Date 2019/12/4 10:49
 * @Version 1.0
 * 顺序排序(每次遍历一遍，把最小的取出或者排到最前位置)
 */
public class OrderSort {
    public static void main(String[] args) {
        int [] arr  = {5,3,6,7,9,0,1,2,8,4};
        int len = arr.length;
        int min  = 0;
        int maxindex  =0;
        for(int i =0;i<len ;i++){
          min  = arr[i];
          for(int j = i;j<len;j++){
              if (arr[j]<min){
                  min  = arr[j];
                  maxindex = j;
              }
          }
          if(min<arr[i]){
              int a = arr[i];
              arr[i] = min;
              arr[maxindex] = a;
          }
        }
        for(int i:arr){
            System.out.println("i="+i);
        }
    }
}
