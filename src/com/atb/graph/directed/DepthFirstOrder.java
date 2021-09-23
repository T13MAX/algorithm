package com.atb.graph.directed;

import com.atb.graph.sp.EdgeWeightedDigraph;
import com.atb.graph.undirected.Graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 有向图中基于深度优先搜索的顶点排序
 *
 * @Author 呆呆
 * @Datetime 2021/9/21 13:12
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private LinkedList<Integer> pre;
    private LinkedList<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph G) {
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) dfs(G, v);
        }
    }

    public DepthFirstOrder(EdgeWeightedDigraph G) {
        System.out.println("DepthFirstOrder构造方法没写");
        /*pre = new int[G.V()];
        post = new int[G.V()];
        postorder = new Queue<Integer>();
        preorder = new Queue<Integer>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);*/
    }

    private void dfs(Digraph G, int v) {
        pre.addLast(v);//循环递归之前加入队列
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
        post.addLast(v);//循环递归之后加入队列
        reversePost.push(v);//逆后续(栈是先进后出的)
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}
