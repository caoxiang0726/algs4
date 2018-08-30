package edu.cx.searching.bst;

/**
 * Created by caoxiang on 2018/8/29.
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;//两个链接（链表只有一个）指向子树
        private int N;//以该节点为根的子树的节点总数

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
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

        public Value get(Key key) {
            return get(root, key);
        }

        private Value get(Node x, Key key) {
            if (x == null) {
                return null;
            }

            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                return get(x.left, key);
            }
            if (cmp > 0) {
                return get(x.right, key);
            }

            return x.val;
        }

        public Node put(Key key, Value val) {//更新 或 新增
            return put(root, key, val);
        }

        private Node put(Node x, Key key, Value val) {
            if (null == x) {
                return
                        new Node(key, val, 1);
            }

            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x.left = put(x.left, key, val);
            } else if (cmp > 0) {
                x.right = put(x.right, key, val);
            } else {
                x.val = val;
            }
            x.N = x.left.N + x.right.N + 1;

            return x;
        }
        // max(), min()
        //select()

        public Key min() {
            return min(root);
        }

        private Key min(Node x) {
            if (null == x.left) {
                return x.key;
            }
            return min(x.left);
        }

        public Key floor(Key key) {
            Node x = floor(root, key);
            if (null == x) {
                return null;
            }
            return x.key;
        }

        private Node floor(Node x, Key key) {
            if (x == null) {
                return null;
            }
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return x;
            }
            if (cmp < 0) {
                return floor(x.left, key);
            }
            //出现 大于0
            Node t = floor(x.right, key);
            if (null != t) {//存在右节点
                return t;
            } else {
                return x;
            }
        }

        public Key select(int k){
            return select(root, k).key;
        }

        private Node select (Node x,int k){
            if (null == x) {
                return null;
            }

            int t = size(x.left);
            if (t == k) {
                return x.left;
            }
            if (k< t) {
                return select(x.left, k);
            }
            return select(x.right,k-t-1);
        }

        public int rank(Key key){
            return rank(root,key);
        }

        private int rank(Node x,Key key){
            if (null == x) {
                return 0;
            }
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return size(x.left);
            }
            if (cmp <0) {
                return rank(x.left,key);
            }
            return rank(x.right, key) + 1 + size(x.left);
        }


    }
}
