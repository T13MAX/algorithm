package com.atb.utils;

import java.util.Random;

public class SortUtil {
    public static Integer[] createArray(){
        Integer[] a=new Integer[15];
        Random r=new Random();
        for(int i=0;i<a.length;i++){
            a[i]=r.nextInt(100);
        }
        return a;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                System.out.println(false);
                return false;
            }
        }
        System.out.println(true);
        return true;
    }
}
