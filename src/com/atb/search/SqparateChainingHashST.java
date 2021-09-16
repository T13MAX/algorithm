package com.atb.search;

/**
 * 基于拉链法的散列表
 * N/M
 * 在顺序不重要的时候最快
 * 软缓存
 *
 * @Author 呆呆
 * @Datetime 2021/9/16 22:36
 */
public class SqparateChainingHashST<K,V>{

    private int N;
    private int M;
    private SqparateChainingHashST<K,V>[] st;

    public SqparateChainingHashST(){
        this(997);//动态调整数组大小更加可靠
    }

    public SqparateChainingHashST(int m) {
        M = m;
        st=(SqparateChainingHashST<K,V>[]) new SqparateChainingHashST[M];
        for(int i=0;i<M;i++){
            st[i]=new SqparateChainingHashST();
        }
    }

    private int hash(K key){
        return (key.hashCode()&0x7fffffff)%M;
    }

    public V get(K key){
        return (V)st[hash(key)].get(key);
    }

    public void put(K key,V value){
        st[hash(key)].put(key,value);
    }



    /*public Iterable<K> keys(){
        return
    }*/
}
