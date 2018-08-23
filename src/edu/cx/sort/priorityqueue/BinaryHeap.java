package edu.cx.sort.priorityqueue;

/**
 * BinaryHeap 二叉堆
 */
public class BinaryHeap {
  /*  private static Comparable[] pq;


    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Comparable v = pq[i];
        pq[j] = pq[i];
        pq[i] = v;
    }

    private void swim(int k) {//堆的有序化，上浮
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }

    }

    private void sink(int k) {//堆的有序化 下沉
        int N = pq.length;
        while (2*k <= N){
            int j = 2*k;
            if (j< N && less(j,j++)){//取两个子元素 较大者
                j++;
            }
            if (less(k,j)) {
                break;
            }
            exch(j,k);
            k = j;


        }

    }*/
}
