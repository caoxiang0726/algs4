package edu.cx.sort.heap;

import edu.cx.sort.SortUtil;

/**
 * 步骤：
 * 1 初始化堆
 * 下面演示将数组{20,30,90,40,70,110,60,10,100,50,80}转换为最大堆{110,100,90,40,80,20,60,10,30,50,70}的步骤
 * <p>
 * 2 下沉排序阶段
 */
public class HeapSort {


    public static void minHeapDown(int[] a, int start, int end) {
        int c = start;            // 当前(current)节点的位置
        int l = 2 * c + 1;        // 左(left)孩子的位置
        int tmp = a[c];            // 当前(current)节点的大小
//        int N = a.length;
//        int k = start;
        for (; l <= end; c = l, l = 2 * l + 1) {
            // "l"是左孩子，"l+1"是右孩子
            if (l < end && a[l] > a[l + 1])
                l++;        // 左右两孩子中选择较小者
            if (tmp <= a[l]){
                break;        // 调整结束
            }
            else {            // 交换值
                a[c] = a[l];
                a[l] = tmp;
            }
        }

    }
    /*private static void sink(int[] a, int k, int end) {//堆的有序化 下沉
        int N = a.length;
        while (2 * k <  N) {
            int j = 2 * k;
            if (j < N && SortUtil.less(j, j+1)) {//取两个子元素 较大者; 必须是j+1 不然比较的是同一个数字
                j++;
            }
            if (SortUtil.less(j, k)) {
                break;
            }
            SortUtil.exch(a,j, k);
            k = j;
        }
    }*/


    public static void maxHeapDown(int[] a, int start, int end) {
        int c = start;            // 当前(current)节点的位置
        int l = 2 * c + 1;        // 左(left)孩子的位置
        int tmp = a[c];            // 当前(current)节点的大小

        for (; l <= end; c = l, l = 2 * l + 1) {
            // "l"是左孩子，"l+1"是右孩子
            if (l < end && a[l] < a[l + 1])
                l++;        // 左右两孩子中选择较大者
            if (tmp >= a[l])
                break;        // 调整结束
            else {            // 交换值
                a[c] = a[l];
                a[l] = tmp;
            }
        }
    }


    public static void sort(Comparable[] a) {
        int N = a.length;


    }

    public static void heapSortAsc(int[] a, int n) {
        int i, tmp;

        // 从(n/2-1) --> 0逐次遍历。遍历之后，得到的数组实际上是一个(最大)二叉堆。
        /**
         * 从左到右遍历数组，然后不断sink也可以获得堆
         * 更聪明的是：跳过大小为1的子堆，只需要遍历数组中一半的元素
         *
         * 得到：10 20 60 30 50 110 90 40 100 70 80
         */
        for (i = n / 2 - 1; i >= 0; i--) {
            minHeapDown(a, i, n - 1);
//            sink(a, i, n - 1);
        }

        System.out.printf("初始化堆OK:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        // 从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
        /*for (i = n - 1; i > 0; i--) {
            // 交换a[0]和a[i]。交换后，a[i]是a[0...i]中最大的。
            tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            // 调整a[0...i-1]，使得a[0...i-1]仍然是一个最大堆。
            // 即，保证a[i-1]是a[0...i-1]中的最大值。  每次都把头元素（最大值） 放到了数组的末尾
            //然后仍然要保证置换后还是二叉堆
            minHeapDown(a, 0, i - 1);
        }*/
    }

    public static void main(String[] args) {
        int i;
        int a[] = {20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        heapSortAsc(a, a.length);            // 升序排列
        //heapSortDesc(a, a.length);        // 降序排列

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }


}
