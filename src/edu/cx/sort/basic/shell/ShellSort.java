package edu.cx.sort.basic.shell;


import edu.cx.sort.SortUtil;

/**
 * 插入排序的1 变成h
 * h有序，数组中任意间隔h的元素的都是有序的。
 *
 * 看不懂了。。
 */
public class ShellSort {

    public static Comparable[] sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j-=h) {
                    System.out.println("j:j-h:"+j+":"+(j-h));
                    if (SortUtil.less(a[j], a[j - h])) {
                        SortUtil.exch(a, j, j - h);
                    }

                }

            }
            h = h / 3;
        }


        return a;
    }

    public static void main(String[] args) {

        Integer[] a = new Integer[]{2, 4, 6, 8, 9, 7, 5, 3, 1};
        Comparable[] sort = sort(a);
        SortUtil.show(sort);
        System.out.println(SortUtil.isSorted(sort));

    }
}
