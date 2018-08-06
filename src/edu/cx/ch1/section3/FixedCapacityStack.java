package edu.cx.ch1.section3;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by caoxiang on 2018/8/6.
 */
import java.util.Iterator;
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
        if (N == entryArr.length) {
            resize(2 * N);
        }
        entryArr[N++] = item;
    }

    public Item pop() {
        Item item = entryArr[--N];
        entryArr[N] = null;//避免对象游离
        if (N > 0 && N == entryArr.length / 4) {
            resize(entryArr.length / 2);
        }

        return item;
    }

    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = entryArr[i];
        }
        entryArr = temp;
    }

    public static void main(String[] args) {
        String s = "to be or not to - be - - that - - - is";
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(100);
        String[] split = s.split(" ");
        for (String s1 : split) {
            if (!"-".equals(s1)) {
                stack.push(s1);
            } else if (!stack.isEmpty()) {
                StdOut.print(stack.pop() + " ");// to be not that or be （两个还在栈中）
            }

        }


    }

    private class ReverseArrayIterator implements Iterator<Item> {//private时，才不会报错
        /**
         * import java.util.Iterator
         * 其实iterator接口应该属于 java.lang的一部分
         * Iterable:实现了Iterable接口的类可以拥有增强的for循环，
         * 即只要实现了Iterable接口的类，就可以使用Iterator迭代器了
         */

        /**
         * 迭代器就是实现了 hasNext next 两个方法的类的对象。
         */

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return entryArr[--i];
        }

        @Override
        public void remove() {

        }
    }


}
