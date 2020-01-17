package edu.cx.sort.merge;

import edu.cx.sort.SortUtil;

/**
 * 将两个有序数组归并为一个有序数组
 *
 */
public class MergeSort {
    private static int[] aux;//原地归并

    public static void sort(int[] a) {
        aux = new int[a.length];
        sort(a, 0, a.length - 1);
        for (int num : a) {
            System.out.print(num + "->");
        }


    }

    private static void sort(int[] a, int lo, int hi) {

        if (hi <= lo) {
            return;//递归  第一规律
        }

        int mid = lo + (hi-lo) / 2;
        sort(a, lo, mid);//左半边归并
        sort(a, mid + 1, hi);//右半边归并
        merge(a, lo, mid, hi);

    }


    public static int[] merge(int[] a, int lo, int mid, int hi) {
//        int[] aux = new int[a.length];
        //合并 lo~mid  和 mid+1 ~ hi
        int i = lo;
        int j = mid + 1;//前后分割点

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {//左半边用尽，取右半边元素
                a[k] = aux[j++];
            } else if (j > hi) {//右半边用尽,取左半边元素
                a[k] = aux[i++];
            } else if (SortUtil.less(aux[j],aux[i])) {//右半边当前元素小于左半边当前元素，取小的。
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];//左半边当前元素 < 右半边  取小。
            }
        }

        return a;


    }

    public static void main(String[] args) {
       /* Integer[] a = new Integer[]{ 3, 1};
        int lo = 0;
        int hi = a.length -1;
        int mid = lo+(hi-lo)/2;
        int[] merge = merge(a, lo, mid, hi);
        for (int int : merge) {
            System.out.print(int+"->");

        }*/

        int[] a = new int[]{8,0,7,5,9,11,4,6,0,6,4,2,15,3,1};

        sort(a);


    }
}
