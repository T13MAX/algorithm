package com.atb.string;

import com.atb.graph.directed.Digraph;
import com.atb.graph.directed.DirectedDFS;
import com.atb.utils.Bag;

import java.util.Stack;

/**
 * 正则表达式的模式匹配
 * 构造长度为M的正则表达式对应的NFA所需的时间和空间与M成正比
 *
 * @Author 呆呆
 * @Datetime 2021/10/11 23:06
 */
public class NFA {
    private char[] re;
    private Digraph G;
    private int M;

    public NFA(String regexp) {
        Stack<Integer> ops = new Stack<>();
        re = regexp.toCharArray();
        M = re.length;
        G = new Digraph(M + 1);
        for (int i = 0; i < M; i++) {
            int lp = i;//左括号的位置
            if (re[i] == '(' || re[i] == '|') {
                ops.push(i);
            } else if (re[i] == ')') {
                int or = ops.pop();
                if (re[or] == '|') {//是或者 那就是或者的下一位到右括号
                    lp = ops.pop();//再出一栈 左括号
                    G.addEdge(lp, or + 1);//左括号到或+1
                    G.addEdge(or, i);//或到i+1
                } else {
                    lp = or;//没有或 那左括号就是右括号出栈对应左括号
                }
            }
            if (i < M - 1 && re[i + 1] == '*') {//* 任意 那就是再指回去
                G.addEdge(lp, i + 1);
                G.addEdge(i + 1, lp);
            }
            if (re[i] == '(' || re[i] == '*' || re[i] == ')') {//指向下一位
                G.addEdge(i, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        NFA nfa = new NFA("((A*B|AC)D)");
        boolean result = nfa.recognizes("AAAABD");
        System.out.println(result ? "匹配" : "不匹配");
    }

    public boolean recognizes(String txt) {
        Bag<Integer> pc = new Bag<>();
        DirectedDFS dfs = new DirectedDFS(G, 0);//有向图可达
        for (int v = 0; v < G.V(); v++) {
            if (dfs.marked(v)) pc.add(v);
        }
        for (int i = 0; i < txt.length(); i++) {
            Bag<Integer> match = new Bag<>();
            for (int v : pc) {
                if (v < M)
                    if (re[v] == txt.charAt(i) || re[v] == '.')
                        match.add(v + 1);
            }
            pc = new Bag<>();
            dfs = new DirectedDFS(G, match);
            for (int v = 0; v < G.V(); v++) {
                if (dfs.marked(v)) pc.add(v);
            }
        }
        for (int v : pc) {
            if (v == M) return true;//检查v有没有符合的
        }
        return false;
    }
}
