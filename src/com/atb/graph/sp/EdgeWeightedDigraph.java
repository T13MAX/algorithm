package com.atb.graph.sp;

import com.atb.graph.tree.Edge;
import com.atb.utils.Bag;
import com.atb.utils.In;

/**
 * 加权无向图
 *
 * @Author 呆呆
 * @Datetime 2021/9/21 22:28
 */
public class EdgeWeightedDigraph {
    private final int V;//顶点数目
    private int E;//边数目
    private Bag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<DirectedEdge>();
        }
    }
    public EdgeWeightedDigraph(In in) {
        this.V = 0;
        System.out.println("EdgeWeightedDigraph构造方法没写");
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj(v)) {
                bag.add(e);
            }
        }
        return bag;
    }
}
