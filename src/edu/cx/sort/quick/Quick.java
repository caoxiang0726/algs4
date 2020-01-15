package edu.cx.sort.quick;

public class Quick {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + "->");
        }
    }

    private static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int j = patition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    public static int patition(int[] arr, int lo, int hi) {
        //将数组分成3部分，a[lo ~ i-1], a[i] ,a[i+1~hi]
        int i = lo;
        int j = hi + 1;
        int pivot = arr[lo];//随机选一个 支点的值，这里取数组第一个值

        while (true) {
            while (less(arr[++i], pivot)) {
                if (i == hi) {
                    break; //左边：找到比支点大的一个位置
                }
            }
            while (less(pivot, arr[--j])) {
                if (j == lo) {
                    break;//右边：找到比支点小的一个位置
                }
            }
            if (i >= j) {
                break;
            }

            exch(arr, i, j);// a[i] > a[j],所以要交换
        }
        exch(arr, lo, j);//返回新的支点位置 lo->j
        return j;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{8, 0, 7, 5, 9, 4, 6, 0, 6, 4, 2, 3, 1};
        int[] a = new int[]{2, 3, 1};

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
