package com.atb.graph.undirected;

import com.atb.utils.Bag;
import com.atb.utils.In;

/**
 * 都没测过555
 * 无向图
 *
 * @Author 呆呆
 * @Datetime 2021/9/20 13:02
 */
public class Graph {
    private final int V;//顶点数目
    private int E;//边数目
    private Bag<Integer>[] adj;//里面是一个链表 记录的是所有和他相连的边 链表的的顺序没任何关系 只是加入顺序

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (Bag<Integer>[]) new Object[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}