package com.dn.sort;

/**
 * @ClassName BubbleSort
 * @Description TODO
 * @Author 郭洪昌
 * @Date 2019/11/19 18:15
 * @Version 1.0
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        Integer arr[] = {2, 4, 7, 6, 8, 5, 9,10,5};
        bubbleSort(arr);
        for(Integer i:arr){
            System.out.print(i+",");
        }
    }

    public static  void bubbleSort(Integer[] arr){
        int len  = arr.length;
        if (len<=1){
            return;
        }

        for(int i=0;i<arr.length-1;i++){
            boolean flag = false;
            for(int j=0;j<arr.length-1-i;j++){
                if( arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }

}
