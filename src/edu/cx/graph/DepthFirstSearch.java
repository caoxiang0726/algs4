package edu.cx.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count; // number of vertices connected to s

    public DepthFirstSearch(Graph G, int s) {//s source起点
        marked = new boolean[G.V()];
        validateVertex(s);
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        count++;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }


    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }

    public static void main(String[] args) throws NoSuchFieldException {
        In in = new In(new File("D:\\ideaWS\\algs4\\src\\edu\\cx\\graph\\data\\tinyG.txt"));
        Graph G = new Graph(in);
        int s = 7;//这里设定从0-12中的0开始
        DepthFirstSearch search = new DepthFirstSearch(G, s);
        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v))
                StdOut.print(v + " ");
        }

        StdOut.println();
        if (search.count() != G.V()) StdOut.println("NOT connected");//一共分成了3块。
        else StdOut.println("connected");
    }

    public int count() {
        return count;
    }

    public boolean marked(int v) {
        validateVertex(v);
        return marked[v];
    }
}
