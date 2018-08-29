package edu.cx.searching.bst;

import java.io.PipedReader;

/**
 * Created by caoxiang on 2018/8/29.
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node{
        private  Key key;
        private  Value val;
        private  Node left,right;//两个链接（链表只有一个）指向子树
        private int N;//以该节点为根的子树的节点总数

        public Node(Key key,Value val,int N){
            this.key = key;
            this.val = val;
            this.N = N;
        }

        public int size(){
            return  size(root);
        }

        public int size(Node x){
            if (null == x) {
                return 0;
            }
            return x.N;
        }

        public Value get(Key key){
            return get(root,key);
        }

        private  Value get(Node x,Key key){
            if (x == null) {
                return null;
            }

            int cmp = key.compareTo(x.key);
            if (cmp<0) {
                return get(x.left, key);
            }
            if (cmp>0) {
                return get(x.right, key);
            }

            return x.val;
        }

        public Node  put(Key key,Value val){//更新 或 新增
            return put(root, key, val);
        }

        private Node put(Node x,Key key,Value val){
            if (null == x) {
                return
                new Node(key, val, 1);
            }

            int cmp = key.compareTo(x.key);
            if (cmp<0) {
                x.left = put(x.left, key, val);
            } else if (cmp >0) {
                x.right = put(x.right, key, val);
            }else {
                x.val = val;
            }
            x.N = x.left.N +x.right.N +1;

            return x;
        }
        // max(), min()
        //select()

    }
}
