package edu.cx.ch1.section3;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by caoxiang on 2018/8/6.
 */
public class FixedCapacityStack<Item> {
    private Item[] entryArr;
    private int N; //size

    public FixedCapacityStack(int cap) {
        entryArr = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        entryArr[N++] = item;
    }

    public Item pop() {
        return entryArr[--N];
    }

    public static void main(String[] args) {
        String s = "to be or not to - be - - that - - - is";
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(100);
        String[] split = s.split(" ");
        for (String s1 : split) {
            if (!"-".equals(s1)) {
                stack.push(s1);
            } else if (!stack.isEmpty()) {
                StdOut.print(stack.pop()+" ");// to be not that or be （两个还在栈中）
            }

        }


    }


}
