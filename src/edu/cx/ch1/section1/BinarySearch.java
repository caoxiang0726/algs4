package edu.cx.ch1.section1;

import java.util.Arrays;

/**
 * Created by caoxiang on 2018/8/5.
 */
public class BinarySearch {

    public static int indexOf(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {//可以使用递归
            int mid = (low + high) / 2;
            if (key == arr[mid]) {
                return mid;
            }
            if (key > arr[mid]) {
                low = mid + 1;
            } else if (key < arr[mid]) {
                high = mid - 1;
            }
        }
        return -1;


    }

    public static void main(String[] args) {

        int[] arr = new int[]{3, 4, 6, 8, 1, 9, 10, 44, 25, 7, 6, 6, 0, 15};
        Arrays.sort(arr);
        int key = 4;
        System.out.println("index:"+indexOf(arr,key));
    }
}
