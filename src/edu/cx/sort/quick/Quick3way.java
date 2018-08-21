package edu.cx.sort.quick;

import edu.cx.sort.SortUtil;
import edu.princeton.cs.algs4.StdRandom;


/**
 * 三向切分 当数组重复数值较多时有优化
 */
public class Quick3way {

    public static void sort(Comparable[] a) {
//        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
        for (Comparable num : a) {
            System.out.print(num + "->");
        }

    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int i = lo + 1;//当前指针，这里以供维持了3个指针
        int lt = lo;
        int gt = hi;
        Comparable v = a[lo];

        while (i <= gt) {
            int cmp = a[i].compareTo(v); // cmp = a[i] - v
            if (cmp < 0) {//当前元素小于参照值
                SortUtil.exch(a, i++, lt++);
            } else if (cmp > 0) {
                SortUtil.exch(a, i, gt--);
            } else {
                i++;
            }



        }
        sort(a,lo,lt-1);//？？？？？？？？？
        sort(a,gt+1,hi);


    }


    public static void main(String[] args) {
        Integer[] a = new Integer[]{8, 0, 7, 5, 9, 4, 6, 0, 6, 4, 2, 3, 1};
//        Integer[] a = new Integer[]{2, 3, 1};

        sort(a);
    }

}
