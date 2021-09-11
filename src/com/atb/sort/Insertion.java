package com.atb.sort;

import com.atb.utils.SortUtil;

/**
 * 插入排序
 *
 * 平均 N**2/4次比较 N**2/4次交换
 * 最坏 N**2/2次比较 N**2/2次交换
 * 最好 N-1次比较 0次交换
 */
public class Insertion {

    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {//循环n-1次 从第二个元素开始往前面插
            for (int j = i; j > 0 && SortUtil.less(a[j], a[j - 1]); j--) {//当前这个与前面所有进行比较 其实就是插入到合适的位置 前面永远是有序的
                SortUtil.exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = SortUtil.createArray();
        SortUtil.show(a);
        sort(a);
        SortUtil.show(a);
        SortUtil.isSorted(a);
    }

}
