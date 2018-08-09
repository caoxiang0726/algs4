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
        Node current = head;
        if (null == head) {
            head = newTailNode;
        } else  {
            while (null != current.next) {//
                current = current.next;//必须引入current
            }
            current.next = newTailNode;
        }
        size++;
        return newTailNode;
    }

    /**
     * 删
     */

    //可能data不在链表内
    public boolean delete(Object data){
        if (0 == size) {
            return false;
        }
        Node current = head;
        Node previous = head;

        while (current.data != data){
            if (null == current.next) {
                return false;//如果一直没匹配到
            }else {
                previous = current;
                current = current.next;
            }
            //匹配到了对应的node

            previous = current.next;
            size--;
            return true;

        }






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
                node = node.next;
            }
            size--;
        }

    }


    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addHead("A");
        linkedList.addHead("B");
        linkedList.addHead("C");
        linkedList.addHead("D");

       /* linkedList.addTail("W");
        linkedList.addTail("X");
        linkedList.addTail("Y");
        linkedList.addTail("Z");*/
        linkedList.display();

    }
}
