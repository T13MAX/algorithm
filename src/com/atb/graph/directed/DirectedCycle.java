package com.atb.graph.directed;

import com.atb.graph.undirected.Graph;

import java.util.Stack;

/**
 * 寻找有向环
 *
 * @Author 呆呆
 * @Datetime 2021/9/21 12:17
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph G) {
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) dfs(G, i);
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (int w : G.adj(v)) {//此顶点的所有连接的顶点返回 进行遍历
            if (this.hasCycle()) {//有环return
                return;
            } else if (!marked[w]) {//每个顶点在递归
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {//被标记过 而且还在环栈里
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);//插入最后一个
                cycle.push(v);//回到v
            }
            onStack[v] = false;
        }
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
