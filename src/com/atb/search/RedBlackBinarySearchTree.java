package com.atb.search;

/**
 * 红黑树
 * 高度不会超过2*lgN
 * 运行时间为对数级别
 * p287性能表
 *
 * 删除操作太复杂太牛逼了
 * 2-3查找树
 *
 * @Author 呆呆
 * @Datetime 2021/9/15 22:33
 */
public class RedBlackBinarySearchTree<K extends Comparable, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private RedBlackBinarySearchTree.Node root;

    private class Node {
        K key;
        V value;
        Node left, right;
        int N;
        boolean color;

        public Node(K key, V value, int n, boolean color) {
            this.key = key;
            this.value = value;
            this.N = n;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private Node rotaleLeft(Node h) {
        Node x = h.right;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotaleRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    public int size() {
        return size(root);
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    public Node put(Node h, K key, V value) {
        if (h == null) return new Node(key, value, 1, RED);//新插入的用红链接和父结点相连
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, value);
        else if (cmp > 0) h.right = put(h.right, key, value);
        else h.value = value;
        if (isRed(h.right) && !isRed(h.left)) h = rotaleLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotaleRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        h.N = size(h.left) + size(h.right) + 1;
        return h;

    }

    public int size(RedBlackBinarySearchTree.Node root) {
        if (root == null) return 0;
        else return root.N;

    }


}
