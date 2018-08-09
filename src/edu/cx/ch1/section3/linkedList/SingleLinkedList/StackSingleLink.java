package edu.cx.ch1.section3.linkedList.SingleLinkedList;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * Created by caoxiang on 2018/8/9.
 */
public class StackSingleLink {
    private SingleLinkedList link;

    public StackSingleLink() {
        link = new SingleLinkedList();
    }

    public void push(Object data) {
        link.addHead(data);
    }

    public Object pop() {
        Object node = link.deleteHead();
        return node;
    }

    public boolean isEmpty() {
        return link.isEmpty();
    }


    public void display() {
        link.display();
    }

    public static void main(String[] args) {
        StackSingleLink stack = new StackSingleLink();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.pop();
        stack.display();
    }
}
