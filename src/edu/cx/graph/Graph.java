package edu.cx.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int V;//顶点数
    private int E;//边数
    private Bag<Integer>[] adj;//邻接表 adjecent

    public Graph(In in) throws NoSuchFieldException {
        this.V = in.readInt();//初始化V 不然private final int V 报错
        if (V < 0) {
            throw new NoSuchFieldException("顶点数不能为负数");
        }
        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
        int E = in.readInt();
        if (E < 0) {
            throw new NoSuchFieldException("边数不能为负数");
        }
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            validateVertex(v);
            validateVertex(w);
            addEdge(v, w);
        }


    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    public String toString() {//打印邻接表
        String s = "";
        s += (V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s += (v + ": ");
            for (int w : adj[v]) {
                s += (w + " ");
            }
            s += (NEWLINE);
        }
        return s.toString();
    }

    public static void main(String[] args) throws NoSuchFieldException {
        In in = new In(new File("D:\\ideaWS\\algs4\\src\\edu\\cx\\graph\\data\\tinyG.txt"));
        Graph G = new Graph(in);
        StdOut.println(G);
    }


}

