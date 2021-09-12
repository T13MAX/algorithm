package com.atb.main;

import com.atb.pq.MaxPQ;


/**
 * @Author 呆呆
 * @Datetime 2021/9/12 21:41
 */
public class AtbMain {
    public static void main(String[] args) {

        maxPQTest();
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
