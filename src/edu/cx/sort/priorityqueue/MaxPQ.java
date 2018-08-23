package edu.cx.sort.priorityqueue;

/**
 * Created by caoxiang on 2018/8/23.
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];//pq[0]没有使用
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key v = pq[i];
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

    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key key){

    }

    public Key delMax(){




        return null;
    }


}
