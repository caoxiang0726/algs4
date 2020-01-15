package edu.cx.sort.quick;

import edu.cx.sort.SortUtil;
import edu.princeton.cs.algs4.StdRandom;


/**
 * 当数组重复数值较多时有优化
 */
public class Quick3way {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + "->");
        }

    }

    private static void sort(int[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int i = lo + 1;//当前指针，这里以供维持了3个指针
        int lt = lo;
        int gt = hi;
        int pivot = arr[lo];

        while (i <= gt) {
            int cmp = arr[i] - pivot;
            if (cmp < 0) {//当前元素小于参照值
                exch(arr, i++, lt++);
            } else if (cmp > 0) {
                exch(arr, i, gt--);
            } else {
                i++;
            }
        }
        sort(arr, lo, lt - 1);
        sort(arr, gt + 1, hi);
    }


    public static void main(String[] args) {
        int[] a = new int[]{8, 0, 7, 5, 9, 4, 6, 0, 6, 4, 2, 3, 1};
        sort(a);
    }

    public static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean less(int v, int w) {
        return v < w;
    }

}
