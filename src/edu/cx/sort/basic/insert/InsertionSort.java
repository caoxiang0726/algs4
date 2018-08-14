package edu.cx.sort.basic.insert;

import edu.cx.sort.SortUtil;

/**
 * 整理扑克
 * <p>
 * 插入排序还分为直接插入排序、二分插入排序、链表插入排序、希尔排序等等
 */
public class InsertionSort {

    public static Comparable[] sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (SortUtil.less(a[j], a[j - 1])) {
                    SortUtil.exch(a, j, j - 1);
                }
            }
        }
        return a;


    }

    public static void main(String[] args) {

        Integer[] a = new Integer[]{2,4,6,8,9,7,5,3,1};
        Comparable[] sort = sort(a);
        SortUtil.show(sort);
        System.out.println(SortUtil.isSorted(sort));

    }

}
