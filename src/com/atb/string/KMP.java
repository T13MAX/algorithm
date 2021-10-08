package com.atb.string;

/**
 * 暴力子字符串
 * Knuth-Morris-Pratt子字符串查找算法
 *
 * @Author 呆呆
 * @Datetime 2021/10/8 23:06
 */
public class KMP {

    //暴力子字符串查找
    public static int violenceSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        for(int i=0;i<=N-M;i++){
            int j;
            for (j = 0; j < M; j++) {
                if(txt.charAt(i+j)!=pat.charAt(j)) break;
            }
            if(j==M) return i;
        }
        return N;//未找到
    }

    public static int violenceSearch_666(String pat, String txt) {
        int j,M=pat.length();
        int i,N=txt.length();
        for(i=0,j=0;i<N&&j<M;i++){
            if(txt.charAt(i)==pat.charAt(j)) j++;
            else {
                i-=j;j=0;
            }
        }
        if(j==M) return i-M;//找到啦
        else return N;//未找到
    }
}
