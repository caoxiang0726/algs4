package edu.cx.graph.Digraph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 有向图中的可达性
 * 可用于：JVM 标记-清除的垃圾回收。
 */
public class DirectedDFS {
    private boolean[] marked;
    private int count;//s 可达顶点的数量

    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        validateVertex(s);
        dfs(G, s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
//        validateVertices(sources);
        for (int v : sources) {
            if (!marked[v]) dfs(G, v);
        }
    }

    private void dfs(Digraph G, int v) {
        count++;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);//简单的代码下蕴含着复杂
        }
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }

    private boolean marked(int v){
        return marked[v];
    }

    public static void main(String[] args) {
        In in = new In("D:\\ideaWS\\algs4\\src\\edu\\cx\\graph\\data\\tinyDG.txt");
        Digraph G = new Digraph(in);

        Bag<Integer> sources = new Bag<Integer>();
        sources.add(2);
//        sources.add(6);
        DirectedDFS dfs = new DirectedDFS(G, sources);
        for (int v = 0; v < G.V(); v++) {
            if (dfs.marked(v)) StdOut.print(v + " ");//可以到达的顶点
        }
        StdOut.println();
    }
}
