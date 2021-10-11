package com.atb.graph.directed;

import com.atb.utils.Bag;
import com.atb.utils.In;

/**
 * 有向图
 *
 * @Author 呆呆
 * @Datetime 2021/9/20 21:54
 */
public class Digraph {
    private final int V;//顶点数目
    private int E;//边数目
    private Bag<Integer>[] adj;//里面是一个链表 记录的是所有和他相连的边 链表的的顺序没任何关系 只是加入顺序

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);//单向
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {//从第一个顶点开始遍历
            for (int w : adj[v]) {//把他所有指向的顶点拎出来遍历
                R.addEdge(w, v);//反向加入
            }
        }
        return R;
    }
}
