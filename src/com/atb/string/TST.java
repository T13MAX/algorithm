package com.atb.string;

/**
 * 三向单词查找树的符号表
 * 链接数在3N~3Nw之间1
 *
 * @Author 呆呆
 * @Datetime 2021/9/29 21:18
 */
public class TST<V> {
    private Node root;

    private class Node<V> {
        char c;
        Node left, mid, right;
        V val;
    }

    public V get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (V) x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        char c = key.charAt(d);
        if (c < x.c) return get(x.left, key, d);
        else if (c > x.c) return get(x.right, key, d);
        else if (d < key.length() - 1) return get(x.mid, key, d);
        else return x;
    }

    public void put(String key, V val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, V val, int d) {
        char c = key.charAt(d);
        if (x == null) {
            x = new Node();
            x.c = c;
        }
        if (c < x.c) x.left = put(x.left, key, val, d);
        else if (c > x.c) x.right = put(x.right, key, val, d);
        else if (d < key.length() - 1) x.mid = put(x.mid, key, val, d + 1);
        else x.val = val;
        return x;
    }

    public String longestPrefixOf(String query) {
        if (query == null) {
            throw new IllegalArgumentException("calls longestPrefixOf() with null argument");
        }
        if (query.length() == 0) return null;
        int length = 0;
        Node<V> x = root;
        int i = 0;
        while (x != null && i < query.length()) {
            char c = query.charAt(i);
            if (c < x.c) x = x.left;
            else if (c > x.c) x = x.right;
            else {
                i++;
                if (x.val != null) length = i;
                x = x.mid;
            }
        }
        return query.substring(0, length);
    }
}
