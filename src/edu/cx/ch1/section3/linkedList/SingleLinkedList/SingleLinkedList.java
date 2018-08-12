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
         Object data;
         Node next;

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
        } else {
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
    public boolean delete(Object data) {
        if (0 == size) {
            return false;
        }
        Node current = head;
        Node previous = head;

        while (current.data != data) {
            if (null == current.next) {
                return false;//如果一直没匹配到
            } else {
                previous = current;
                current = current.next;//current执行下一个节点，上下两个句也能保证p比c靠前一个节点
            }
        }
        //匹配到了对应的node
        if (current == head) {
            head = current.next;
        } else {
            previous.next = current.next;//将previous.next 指向当前节点下一个；当前节点垃圾回收。
        }
        size--;
        return true;

    }

    public Node deleteHead() {
        Node headNode = head;
        if (0 == size) {
            return null;
        }
        head = head.next;
        size--;
        return headNode;
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
        int tempSize = size;
        while (tempSize > 0) {
            if (null == node.next) {//最后一个节点无需 ->
                System.out.print("[" + node.data + "]");
            } else {
                System.out.print("[" + node.data + "]->");
                node = node.next;
            }
            tempSize--;//显示后要将size复原
        }

    }


    public boolean isEmpty() {
        return 0 == size;
    }


    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addHead("A");
        linkedList.addHead("B");
        linkedList.addHead("C");
        linkedList.addHead("D");

        linkedList.addTail("W");
        linkedList.addTail("X");
        linkedList.addTail("Y");
        linkedList.addTail("Z");

//        linkedList.delete("NO EXIST");//还有问题
//        linkedList.delete("A");
//        linkedList.delete("B");
//        linkedList.delete("D");
        linkedList.display();
        System.out.println("");

        linkedList.deleteHead();
//        System.out.println(node.data);
        linkedList.display();

    }
}
