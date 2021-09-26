package com.atb.string;

/**
 * 低位优先的字符串排序
 *
 * @Author 呆呆
 * @Datetime 2021/9/26 22:25
 */
public class LSD {
    public static void main(String[] args) {

    }

    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;
        String aux[] = new String[N];
        for (int d = W - 1; d >= 0; d--) {//每个字符串有多少位 循环多少次
            int[] count = new int[R + 1];
            for (int i = 0; i < N; i++) {//计算出现频率 a[i]是遍历字符串数组 charAt找字符 d就是倒着排 第几个
                count[a[i].charAt(d) + 1]++;
            }
            for (int r = 0; r < R; r++) {//将频率转换为索引
                count[r + 1] += count[r];
            }
            for (int i = 0; i < N; i++) {//将元素分类
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            for (int i = 0; i < N; i++) {//回写
                a[i] = aux[i];
            }
        }
    }
}
