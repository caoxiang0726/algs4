package edu.cx.sort.merge;

/**
 * Created by caoxiang on 2018/8/14.
 */
public class MergeSort {

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        Comparable[] aux = new Comparable[a.length];
        //合并 lo~mid  和 mid+1 ~ hi
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k < hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k < hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j>hi) {
                a[k] = aux[i++];
            } else if (j>hi) {
                a[k] = aux[j++];
            }else {
                a[k] = aux[i++];
            }
        }

        for (Comparable c : a) {
            System.out.println((Integer) c);

        }


    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{2, 3,1};
        merge(a, 0, 1, 1);

    }
}
