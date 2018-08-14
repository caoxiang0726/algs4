package edu.cx.sort.basic.SelectionSort;

/**
 * 方法模板可用于其他排序
 */
public class SelectionSort {
    public static Comparable[] sort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j],a[min])) {
                    min = j;
                }
            }
            exch(a,i,min);
        }
        return a;
    }


    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;// v<w返回ture
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (Comparable comparable : a) {
            System.out.print(comparable + "");
        }
        System.out.println("");
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 10; i < a.length - 1; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(less(1, 2));

//        String[] a = {"5","A","0","C","B"};
        Integer[] a = {2,4,6,8,7,5,1,3,9};
        Comparable[] sort = sort(a);
        show(sort);
        System.out.println(isSorted(sort));
    }
}
