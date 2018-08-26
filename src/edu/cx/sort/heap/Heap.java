package edu.cx.sort.heap;

import edu.princeton.cs.algs4.StdOut;

public class Heap {

    // This class should not be instantiated.
    private Heap() { }

    public static void sort(Comparable[] pq) {
        int n = pq.length;
        // 1 初始化堆
        for (int k = n/2; k >= 1; k--)
            sink(pq, k, n);

        //2
        while (n > 1) {
            // 将最大值放置在最后
            exch(pq, 1, n--);
            //恢复成二叉堆
            sink(pq, 1, n);
        }
    }


    private static void sink(Comparable[] pq, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; heapsorts them; 
     * and prints them to standard output in ascending order. 
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
//        String[] a = new String[]{"c","a","b","f","g"};
        Integer[] a = {20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80};
        Heap.sort(a);
        show(a);
    }
}
