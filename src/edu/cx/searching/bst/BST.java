package edu.cx.searching.bst;

import edu.princeton.cs.algs4.Queue;

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


        public Key min() {
            return min(root).key;
        }

        private Node min(Node x) {
            if (null == x.left) {
                return x;
            }
            return min(x);
        }

        public Key max() {
            return max(root).key;
        }

        private Node max(Node x) {
            if (null == x.right) {
                return x;
            }
            return max(x.right);


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

        public Key select(int k) {
            return select(root, k).key;
        }

        private Node select(Node x, int k) {
            if (null == x) {
                return null;
            }

            int t = size(x.left);
            if (t == k) {
                return x.left;
            }
            if (k < t) {
                return select(x.left, k);
            }
            return select(x.right, k - t - 1);
        }

        public int rank(Key key) {
            return rank(root, key);
        }

        private int rank(Node x, Key key) {
            if (null == x) {
                return 0;
            }
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return size(x.left);
            }
            if (cmp < 0) {
                return rank(x.left, key);
            }
            return rank(x.right, key) + 1 + size(x.left);
        }

        public void deleteMin() {
            root = deleteMin(root);
        }

        private Node deleteMin(Node x) {
            if (x.left == null) {
                return x.right;
            }
            x.left = deleteMin(x.left);
            //整理节点
            x.N = size(x.left) + size(x.right) + 1;
            return x;

        }

        public void delete(Key key) { //难???
            delete(root, key);
        }

        private Node delete(Node x, Key key) {
            if (x == null) {
                return null;
            }

            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x.left = delete(x.left, key);
            } else if (cmp > 0) {
                x.right = delete(x.right, key);
            } else {//找到
                if (x.right == null) {//该节点最多只有一个子树
                    return x.left;
                }
                if (x.left == null) {
                    return x.right;
                }
                Node t = x;
                x = min(t.right);
                x.right = deleteMin(x.right);
                x.left = t.left;
            }
            x.N = size(x.right) + size(x.left) + 1;
            return x;

        }

        /**
         * 范围查找
         * 中序遍历-打印的由小到大
         */

        private void print(Node x) {
            if (x == null) {
                return;
            }
            print(x.left);
            System.out.print(x.key);
            print(x.right);
        }

        public Iterable<Key> keys() {
            return keys(min(), max());
        }

        public Iterable<Key> keys(Key lo, Key hi) {
            Queue<Key> queue = new Queue<Key>();
            keys(root, queue, lo, hi);
            return queue;

        }

        private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
            if (null == x) {
                return;
            }
            int cmplo = lo.compareTo(x.key);
            int cmphi = hi.compareTo(x.key);
            if (cmplo < 0) {
                keys(x.left, queue, lo, hi);
            }
            if (cmplo >= 0 && cmphi <= 0) {
                queue.enqueue(x.key);
            }
            if (cmphi > 0) {
                keys(x.right, queue, lo, hi);
            }

        }


    }
}
