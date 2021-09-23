package com.atb.graph.directed;


import com.atb.graph.sp.EdgeWeightedDigraph;
import com.atb.graph.sp.EdgeWeightedDirectedCycle;

/**
 * 拓扑排序
 * 拓扑排序就是逆后续排列
 * 所需时间和V+E成正比
 *
 * @Author 呆呆
 * @Datetime 2021/9/21 13:20
 */
public class Topological {
    private Iterable<Integer> order;

    public Topological(Digraph G) {
        DirectedCycle directedCycle = new DirectedCycle(G);
        if (!directedCycle.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Topological(EdgeWeightedDigraph G) {
        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(G);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }

    public boolean hasOrder() {
        return order != null;
    }

}
