package edu.cx.ch1.section3.linkedList.SingleLinkedList;


/**
 * 不太会改造成泛型的node,或是思路就是错误的
 */
public class SingleLinkedList {

    private int size;
    private Node head;

    public SingleLinkedList() {
        this.size = 0;
        this.head = null;
    }


    private class Node {//
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    /**
     * 增
     */

    //在链表头添加元素
    public Object addHead(Object node) {
        Node newHeadNode = new Node(node);
        //最开始的时候 head = null
        if (0 == size) {
            head = newHeadNode;
        } else {
            newHeadNode.next = head;
            head = newHeadNode;
        }
        size++;
        return node;
    }

    public Object addTail(Object node) { //
        Node newTailNode = new Node(node);
        if (null == head) {
            head = newTailNode;
        } else  {
            while (null != head.next) {
                head = head.next;
            }
            head.next = newTailNode;
        }
        size++;
        return newTailNode;
    }

    /**
     * 删
     */

    //
    public boolean delete(Node node){




        return false;
    }


    /**
     * 查（-> 改，显示）
     */

    public void display() {
        Node node = head;
        if (0 == size) {
            System.out.print("[null]");
            return;
        }
        while (size > 0) {
            if (null == node.next) {//最后一个节点无需 ->
                System.out.print("[" + node.data + "]");
            } else {
                System.out.print("[" + node.data + "]->");
                node = head.next;
            }
            size--;
        }

    }


    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
//        linkedList.addHead("A");
//        linkedList.addHead("B");

        linkedList.addTail("X");
        linkedList.addTail("Y");
        linkedList.display();

    }
}
