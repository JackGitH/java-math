package com.dn.sort;

/**
 * @ClassName test
 * @Description TODO
 * @Author 郭洪昌
 * @Date 2019/11/19 15:12
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) {
        int[] arr  = {1,2,3,7,6};
        int begin = 0;
        int end = arr.length-1;
        quickSort(arr,begin,end);
        for(int i:arr){
            System.out.print(i);
        }
        System.out.println();


    }


    public static void quickSort(int[] arr,int low,int high){
       if(low<high){
           int midle = getMidle(arr,low,high);
           quickSort(arr,0,midle);
           quickSort(arr,midle+1,high);
       }
    }

    public static int  getMidle(int[] arr,int low,int hign){
        int tmp = arr[low];
        int begin = low;
        int end = hign;
        while(begin<end){
            while(begin<end && arr[end]>tmp){
                end--;
            }
            arr[begin] = arr[end];

            while(begin<end && arr[begin]<tmp){
                begin++;
            }
            arr[end] = arr[begin];
        }
        arr[begin] = tmp;
        return begin;
    }


}
