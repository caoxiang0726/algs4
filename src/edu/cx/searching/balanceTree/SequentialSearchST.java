package edu.cx.searching.balanceTree;

/**
 * 基于无序链表
 */
public class SequentialSearchST<Key, Value> {
    private Node first;//首节点


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
        for(Node x = first;x!=null;x = x.next){
            if (x.key.equals(key)) {
                return x.val;
            }
        }

        return null;
    }

    public void  put(Key key,Value value){
        for(Node x = first;x!=null;x = x.next){
            if (key.equals(x.key)) {
                x.val = value;
            }

        }

        first = new Node(key, value, first);//插入链表头


    }

    public static void main(String[] args) {

        SequentialSearchST st = new SequentialSearchST();
        st.put("1","dog");
        st.put("2","cat");
        st.put("1","fox");


    }


}
