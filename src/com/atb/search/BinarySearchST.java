package com.atb.search;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Queue;

/**
 * 二分查找
 * 最多lgN+1次比较
 * @Author 呆呆
 * @Datetime 2021/9/13 22:40
 */
public class BinarySearchST<K extends Comparable, V> {
    private K[] keys;
    private V[] values;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (K[]) new Comparable[capacity];//调整数组大小的标准代码在1.1节 我估计就是添加的时候不够了就乘2 删除了少于一半就减小之类的
        values = (V[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public V get(K key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return values[i];
        else return null;
    }

    //基于有序数组的二分查找
    public int rank(K key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;//保证mid永远在剩余的里面的中间的位置
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) hi = mid + 1;
            else return mid;
        }
        return lo;//没找到
    }

    //递归的二分查找
    public int rank(K key, int lo, int hi) {
        if (hi < lo) return lo;//没找到 返回比他小一点的那个
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) return rank(key, lo, mid - 1);
        else if (cmp > 0) return rank(key, mid + 1, hi);
        else return mid;
    }

    public void put(K key, V value) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];//保持有序
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public void delete(K key) {
        int i = rank(key);
        for (int j = i; j < N; j++) {
            keys[j + 1] = keys[j];
            values[j + 1] = values[j];//保持有序
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public K min() {
        return keys[0];
    }

    public K max() {
        return keys[N - 1];
    }

    public K select(int i) {
        return keys[i];
    }

    //上限
    public K ceiling(K key) {
        int i = rank(key);
        return keys[i];
    }

    //public K floor(K key)

    public Iterator<K> keys(K lo,K hi) {
       /* Queue<K> q=new Queue<K>();
        for(int i=rank(lo);i<rank(hi);i++){
            q.enqueue(K)
        }*/
        return null;
    }



}
