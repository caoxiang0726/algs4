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
        pq[i] = pq[j];
        pq[j] = v;
    }

    private void swim(int k) {//堆的有序化，上浮
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }

    }

    private void sink(int k) {//堆的有序化 下沉
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j+1)) {//取两个子元素 较大者; 必须是j+1 不然比较的是同一个数字
                j++;
            }
            if (less(j, k)) {
                break;
            }
            exch(j, k);
            k = j;
        }
    }



    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }


    public void print(Key[] pq) {
        for (Key key : pq) {
            if (null != key) { //排除第0个元素，和其余的空值。
                System.out.print(key + "->");
            }
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        MaxPQ maxPQ = new MaxPQ(20);
        maxPQ.insert(3);
        maxPQ.insert(1);
        maxPQ.insert(8);
        maxPQ.insert(9);
        maxPQ.insert(5);
        maxPQ.insert(2);
        maxPQ.insert(4);
        maxPQ.insert(7);

        maxPQ.print(maxPQ.pq);

        maxPQ.delMax();
        maxPQ.delMax();
        maxPQ.print(maxPQ.pq);

    }


}
