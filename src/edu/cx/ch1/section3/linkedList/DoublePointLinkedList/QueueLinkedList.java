package edu.cx.ch1.section3.linkedList.DoublePointLinkedList;

/**
 * 用双端链表实现队列
 */
public class QueueLinkedList {
    private DoublePointLinkedList dp;

    public QueueLinkedList(){
        dp = new DoublePointLinkedList();
    }

    public void  enqueue(Object data){
         dp.addTail(data);
    }

    public boolean dequeqe(){
        return dp.deleteHead();
    }

    public void display(){
        dp.display();
    }

    public static void main(String[] args) {
        QueueLinkedList qll = new QueueLinkedList();
        qll.enqueue("A");
        qll.enqueue("B");
        qll.enqueue("C");
        qll.display();
        qll.dequeqe();
        System.out.println("");
        qll.display();
    }
}
