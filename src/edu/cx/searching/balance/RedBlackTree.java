package edu.cx.searching.balance;


/**
 *
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        int N;
        boolean color;//该节点到父节点的链接的颜色 可以拉平

        public Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;//约定空链接为黑色
        }

        return x.color == RED;

    }


    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (null == x) {
            return 0;
        }
        return x.N;
    }

    /**
     * 修复异常情况 1 红色右连接 或者 2 两条连续的红色左连接
     * <p>
     * 插入的链接初始都是红色，如果刚插入的是右孩子，就出现了红色右连接
     */
    public Node rotateLeft(Node p) {//左旋：较大者变为根节点(水平投影有序的前提) p是当前父节点
        Node right = p.right;
        p.right = right.left;
        right.left = p;

        right.color = p.color;//保留原有颜色，可能会两条连续的红色连接
        p.color = RED;
        right.N = p.N;//继承
        p.N = size(p.right) + size(p.left) + 1;
        return right;
    }

    public Node rotateRight(Node p) {//右旋：left,right互换即可
        Node left = p.left;
        p.left = left.right;
        left.right = p;

        left.color = p.color;//保留原有颜色，可能会两条连续的红色连接
        p.color = RED;
        left.N = p.N;//继承
        p.N = size(p.right) + size(p.left) + 1;
        return left;
    }

    void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(Key key, Value val) {
        put(root, key, val);
    }

    private Node put(Node h, Key key, Value val) {//书中最复杂之一，但是delete更加复杂
        if (h == null) {
            return new Node(key, val, 1, RED);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, val);
        } else if (cmp > 0) {
            h.right = put(h.right, key, val);
        } else {
            h.val = val;
        }

        if (isRed(h.right) && !isRed(h.left)) {//新键位于两者之间，最复杂的情况
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

}
