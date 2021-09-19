package com.atb.main;

import com.atb.pq.MaxPQ;
import com.atb.search.*;


/**
 * @Author 呆呆
 * @Datetime 2021/9/12 21:41
 */
public class AtbMain {
    public static void main(String[] args) {

        LinearProbingHashST<Integer,Integer> linearProbingHashST = new LinearProbingHashST();
        linearProbingHashST.put(1, 1);
        linearProbingHashST.put(2, 2);
        linearProbingHashST.put(4, 4);
        linearProbingHashST.put(2, 222);
        linearProbingHashST.put(3, 33);
        linearProbingHashST.put(6, 66);
        linearProbingHashST.put(8, 88);
        linearProbingHashST.put(7, 77);
        linearProbingHashST.put(5, 55);
        linearProbingHashST.put(9, 99);
        System.out.println(linearProbingHashST.get(1));
        System.out.println(linearProbingHashST.get(2));
        System.out.println(linearProbingHashST.get(3));
        System.out.println(linearProbingHashST.get(4));
        System.out.println(linearProbingHashST.get(5));
        System.out.println(linearProbingHashST.get(6));
        System.out.println(linearProbingHashST.get(7));
        System.out.println(linearProbingHashST.get(8));
        System.out.println(linearProbingHashST.get(9));

        //testSequentialChaining();//傻逼不好使

        //testRedBlackTree();

        //testBinarySearchTree();

        //testBinarySearch();

        //testSequentialSearch();//测试无序链表的顺序查找

        //maxPQTest();

    }

    private static void testSequentialChaining() {
        SeparateChainingHashST<Integer,Integer> separateChainingHashST = new SeparateChainingHashST();
        separateChainingHashST.put(1, 1);
        separateChainingHashST.put(2, 2);
        separateChainingHashST.put(4, 4);
        separateChainingHashST.put(2, 222);
        separateChainingHashST.put(3, 33);
        separateChainingHashST.put(6, 66);
        separateChainingHashST.put(8, 88);
        separateChainingHashST.put(7, 77);
        separateChainingHashST.put(5, 55);
        separateChainingHashST.put(9, 99);
        System.out.println(separateChainingHashST.get(1));
        System.out.println(separateChainingHashST.get(2));
        System.out.println(separateChainingHashST.get(3));
        System.out.println(separateChainingHashST.get(4));
        System.out.println(separateChainingHashST.get(5));
        System.out.println(separateChainingHashST.get(6));
        System.out.println(separateChainingHashST.get(7));
        System.out.println(separateChainingHashST.get(8));
        System.out.println(separateChainingHashST.get(9));
    }

    private static void testRedBlackTree() {
        RedBlackBinarySearchTree<Integer, Integer> redBlackTree = new RedBlackBinarySearchTree<>();
        redBlackTree.put(1, 1);
        redBlackTree.put(2, 2);
        redBlackTree.put(4, 4);
        redBlackTree.put(2, 222);
        redBlackTree.put(3, 33);
        redBlackTree.put(6, 66);
        redBlackTree.put(8, 88);
        redBlackTree.put(7, 77);
        redBlackTree.put(5, 55);
        redBlackTree.put(9, 99);
        //redBlackTree.delete(1);
        redBlackTree.deleteMin();
        System.out.println(redBlackTree.get(1));
        System.out.println(redBlackTree.get(2));
        System.out.println(redBlackTree.get(3));
        System.out.println(redBlackTree.get(4));
        System.out.println(redBlackTree.get(5));
        System.out.println(redBlackTree.get(6));
        System.out.println(redBlackTree.get(7));
        System.out.println(redBlackTree.get(8));
        System.out.println(redBlackTree.get(9));
        System.out.println("数组大小为" + redBlackTree.size());
        System.out.println("最小" + redBlackTree.min());
        System.out.println("最大" + redBlackTree.max());
    }

    private static void testBinarySearchTree() {
        BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.put(1, 1);
        binarySearchTree.put(2, 2);
        binarySearchTree.put(4, 4);
        binarySearchTree.put(2, 222);
        binarySearchTree.put(3, 33);
        binarySearchTree.put(6, 66);
        binarySearchTree.put(7, 77);
        binarySearchTree.put(8, 88);
        binarySearchTree.put(9, 99);
        //binarySearchTree.delete(1);
        //binarySearchTree.deleteMin();
        System.out.println(binarySearchTree.get(1));
        System.out.println(binarySearchTree.get(2));
        System.out.println(binarySearchTree.get(3));
        System.out.println(binarySearchTree.get(4));
        System.out.println(binarySearchTree.get(6));
        System.out.println(binarySearchTree.get(7));
        System.out.println(binarySearchTree.get(8));
        System.out.println(binarySearchTree.get(9));
        binarySearchTree.print();
        for (Integer key : binarySearchTree.keys()) {
            System.out.print(key + " ");
        }
        System.out.println();
        System.out.println("数组大小为" + binarySearchTree.size());
        System.out.println("最小" + binarySearchTree.min());
        System.out.println("最大" + binarySearchTree.max());
        System.out.println("第四个" + binarySearchTree.select(4));
        System.out.println("小于4的有" + binarySearchTree.rank(4));
        System.out.println("比4大的最小" + binarySearchTree.floor(4));
    }

    private static void testBinarySearch() {
        BinarySearch<Integer, Integer> binarySearch = new BinarySearch<Integer, Integer>(10);
        binarySearch.put(1, 1);
        binarySearch.put(2, 4);
        binarySearch.put(4, 8);
        binarySearch.put(2, 99);
        binarySearch.put(3, 11);
        binarySearch.delete(1);
        System.out.println(binarySearch.get(1));
        System.out.println(binarySearch.get(2));
        System.out.println(binarySearch.get(3));
        System.out.println(binarySearch.get(4));
        System.out.println("数组大小为" + binarySearch.size());
    }

    private static void testSequentialSearch() {
        SequentialSearchST<Integer, Integer> sequentialSearch = new SequentialSearchST<>();
        sequentialSearch.put(1, 1);
        sequentialSearch.put(2, 4);
        sequentialSearch.put(3, 8);
        sequentialSearch.put(2, 99);
        System.out.println(sequentialSearch.get(1));
        System.out.println(sequentialSearch.get(2));
        System.out.println(sequentialSearch.get(3));
    }

    public static void maxPQTest() {
        MaxPQ<Integer> pq = new MaxPQ<>(10);
        pq.insert(1);
        pq.insert(75);
        pq.insert(85);
        pq.insert(18);
        pq.insert(51);
        pq.delMax();
        pq.insert(16);
        pq.insert(41);
        pq.show();
    }
}
