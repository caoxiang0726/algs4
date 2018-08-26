package edu.cx.searching.balanceTree;

/**
 * 基于无序链表
 */
public class SequentialSearchST<Key, Value> {
    private Node first;


    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }

    }

    public Value get(Key key){
        return null;
    }

    public void  put(Key key,Value value){

    }

    public static void main(String[] args) {

    }


}
