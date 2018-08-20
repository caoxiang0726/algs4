package edu.cx.sort.quick;

import edu.princeton.cs.algs4.StdRandom;

import static edu.cx.sort.SortUtil.exch;
import static edu.cx.sort.SortUtil.less;

/**
 * Created by caoxiang on 2018/8/20.
 */
public class Quick {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
        for (Comparable num : a) {
            System.out.print(num + "->");
        }

    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int j = patition1(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static int patition1(Comparable[] a, int lo, int hi) {
        //将数组分成3部分，a[lo ~ i-1], a[i] ,a[i+1~hi]
        int i = lo;
        int j = hi + 1;//两个指针
        Comparable v = a[lo];//切分元素

        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {//????
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }

            exch(a, i, j);// a[i] > a[j],所以要交换
        }
        exch(a,lo,j);//将v换到正确的位置
        return j;

    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{8,0,7,5,9,4,6,0,6,4,2,3,1};

        sort(a);
    }
}
