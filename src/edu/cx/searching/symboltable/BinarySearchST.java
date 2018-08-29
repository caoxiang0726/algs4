package edu.cx.searching.symboltable;

/**
 * 二分查找，基于有序数组
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST() {


    }

    public int size() {
        return 0;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }

        int i = rank(key);//复杂度 对数级
        if (i<N && keys[i].compareTo(key) == 0) {
            return vals[i];
        }else {
            return null;
        }
    }


    public void push(Key key, Value value) {

        int i = rank(key);
        if (i<N && keys[i].compareTo(key) == 0) {
            vals[i] = value;
            return;
        }
        //新增  复杂度 线性；插入N个元素就要平方级别。要改进
        /**
         * 二叉查找树 可以让插入也变成对数级别的复杂度
         */
        for(int j = N;j>i;j--){
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = value;
        N++;

    }

    public int rank(Key key) {
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (lo + hi) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return lo;//第一次插入 hi = -1
    }

    public void delete(Key key) {

    }

    public boolean isEmpty(){
        return  0 == N;
    }

    public Key min(){
        return keys[0];
    }

    public  Key max(){
        return keys[N-1];
    }

    public Key select(int i){
        return keys[i];
    }

    public Key ceilling(Key key){
       return null;
    }


    public static void main(String[] args) {

    }


}
