package edu.cx.sort.priorityqueue;

import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

/**
 * 优先队列有一个缺点，就是不能直接访问已存在于优先队列中的对象，并更新它们
 *
 * 没有理解
 */

public class IndexMaxPQ<Key extends Comparable<Key>> {
    private int n;           //队列长度
    private Key[] keys;      // 存储值
    private int[] pq;        //使用一级索引（clustered index）的二叉堆

    //    存储与对象相关的整数在pq数组中的下标，并在上浮和下沉的过程中同时维护它
    private int[] qp;        // pq的对称映射 qp[pq[i]] = pq[qp[i]] = i，用于映射key索引对应pq二叉堆中的位置


    public IndexMaxPQ(int maxN) {
        if (maxN < 0) throw new IllegalArgumentException();
        n = 0;
        keys = (Key[]) new Comparable[maxN + 1];// null
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];                   // 长度大小一致，值初始化全为-1
        for (int i = 0; i <= maxN; i++)
            qp[i] = -1;
    }


    public boolean isEmpty() {
        return n == 0;
    }


    public boolean contains(int i) {
        return qp[i] != -1;
    }


    public int size() {
        return n;
    }


    public void insert(int i, Key key) {
        //主键索引
        if (contains(i)) {
            throw new IllegalArgumentException("index is already in the priority queue");
        }
        n++;//从1开始
        qp[i] = n;//和keys[] 的下标保持一致 i 是从0开始，是输入的下标
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }


    public int maxIndex() {
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }


    public Key maxKey() {
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        return keys[pq[1]];
    }


    public int delMax() {
        if (n == 0) throw new NoSuchElementException("Priority  queue underflow");
        int min = pq[1];
        exch(1, n--);
        sink(1);

        assert pq[n + 1] == min;//?
        qp[min] = -1;
        System.out.println("当前最大值：KEYS索引="+min+"，keys值"+keys[min]);
        keys[min] = null;
        pq[n + 1] = -1;
        return min;
    }


    public Key keyOf(int i) {
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        else return keys[i];
    }


    public void changeKey(int i, Key key) {
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        keys[i] = key;
        swim(qp[i]);
        sink(qp[i]);
    }


    /*@Deprecated
    public void change(int i, Key key) {
        changeKey(i, key);
    }*/


    public void increaseKey(int i, Key key) {
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) >= 0)
            throw new IllegalArgumentException("Calling increaseKey() with given argument would not strictly increase the key");

        keys[i] = key;
        swim(qp[i]);
    }


    public void decreaseKey(int i, Key key) {
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) <= 0)
            throw new IllegalArgumentException("Calling decreaseKey() with given argument would not strictly decrease the key");

        keys[i] = key;
        sink(qp[i]);
    }


    public void delete(int i) {
        if (!contains(i)) throw new NoSuchElementException("index  is not in the priority queue");
        int index = qp[i];
        exch(index, n--);
        swim(index);
        sink(index);
        keys[i] = null;
        qp[i] = -1;
    }


    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        // qp 也交换对应值
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }


    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        // 插入改变优先级
        String[] strings = {"a", "c", "b", "d"};

        IndexMaxPQ<String> pq = new IndexMaxPQ<String>(strings.length);
        for (int i = 0; i < strings.length; i++) {
            pq.insert(i, strings[i]);
        }
        System.out.println("当前最大值："+pq.maxKey());


        while (!pq.isEmpty()) {
            int i = pq.delMax();
            StdOut.print(i + "-" + strings[i] + "|");
        }
        StdOut.println();

    }
}