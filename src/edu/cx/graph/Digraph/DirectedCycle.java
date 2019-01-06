package edu.cx.graph.Digraph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

/**
 * 是否有环
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack;
    private Stack<Integer> cycle; // directed cycle (or null if no such cycle)

    public DirectedCycle(Digraph G) {
        marked  = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo  = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v] && cycle == null) dfs(G, v);
    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;//新增onStack状态,初始化
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (cycle != null) return;
            else if (!marked[w]) {
                edgeTo[w] = v;//
                dfs(G, w);
            }
            // 搜索是否有环
            else if (onStack[w]) {//w被标记了，onStack上也为true-->有环
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                assert check();
            }
        }
        onStack[v] = false;
    }

    private boolean check() {

        if (hasCycle()) {
            // verify cycle
            int first = -1, last = -1;
            for (int v : cycle()) {
                if (first == -1) first = v;
                last = v;
            }
            if (first != last) {
                System.err.printf("cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }


        return true;
    }

    public boolean hasCycle() {
        return cycle != null;
    }
    public Iterable<Integer> cycle() {
        return cycle;
    }

    public static void main(String[] args) {
        In in = new In(new File("D:\\ideaWS\\algs4\\src\\edu\\cx\\graph\\data\\tinyDG.txt"));
        Digraph G = new Digraph(in);

        DirectedCycle finder = new DirectedCycle(G);
        if (finder.hasCycle()) {
            StdOut.print("Directed cycle: ");
            for (int v : finder.cycle()) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }

        else {
            StdOut.println("No directed cycle");
        }
        StdOut.println();
        //Directed cycle: 3 5 4 3
    }

}
