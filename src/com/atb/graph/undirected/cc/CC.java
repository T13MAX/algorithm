package com.atb.graph.undirected.cc;

import com.atb.graph.undirected.Graph;

/**
 * 连通分量
 * 需要对图进行预处理
 * 而union-find在 要判断连通性或大量连通性和插入混合时
 * @Author 呆呆
 * @Datetime 2021/9/20 20:58
 */
public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) {
                dfs(G, i);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {//此顶点的所有连接的顶点返回 进行遍历
            if (!marked[w]) {//每个顶点在递归
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
}
