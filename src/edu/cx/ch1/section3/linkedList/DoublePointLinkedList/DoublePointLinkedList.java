package edu.cx.ch1.section3.linkedList.DoublePointLinkedList;

/**
 * 引入原因：单向链表尾插太麻烦
 *
 * 添加节点两步骤（包括头插，尾插，单向，双端）
 *   1： X.next = Y   (X,Y代表两个节点，至于怎么考虑，想象下最终的图像是哪个节点在前才能next)
 *   2：对head/tail 用新节点重新赋值
 */
public class DoublePointLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private Object data;
        private Node next;

        public Node (Object data){
            this.data = data;
        }
    }

    public DoublePointLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 增
     */
    public Node addHead(Object data){
        Node newHead = new Node(data);
        if (null == head) {
            head = newHead;
            tail = newHead;
            size++;
            return  newHead;
        }

        newHead.next = head;
        head = newHead;
        return  newHead;

    }


    public Node addTail(Object data){
        Node newTail = new Node(data);
        if (null == tail) {
            head = newTail;
            tail = newTail;
            size++;
            return newTail;
        }
        tail.next = newTail;
        tail = newTail;
        size++;
        return newTail;

    }


    /**
     * 删
     */

    public boolean deleteHead(){
        if (isEmpty()) {
            return false;
        }

        if (null == head.next) {
            head = null;
            tail = null;
        }else {
            head = head.next;
        }
        size--;
        return true;

    }


    /**
     * 改 查
     */

    public void  display(){
        Node tempHead = head;
        if (isEmpty()) {
            System.out.println("[null]");
            return;
        }

        while (null != tempHead.next) {
            System.out.print("["+tempHead.data+"]->");
            tempHead = tempHead.next;
        }
        System.out.print("["+tempHead.data+"]");
    }




    public boolean isEmpty() {
        return 0 == size;
    }


    public static void main(String[] args) {
        DoublePointLinkedList linkedList = new DoublePointLinkedList();
        linkedList.addHead("A");
        linkedList.addHead("B");
        linkedList.addHead("C");


        linkedList.addTail("X");
        linkedList.addTail("Y");
        linkedList.addTail("Z");



        linkedList.display();

        linkedList.deleteHead();
        linkedList.deleteHead();
        System.out.println("");
        linkedList.display();

    }
}
