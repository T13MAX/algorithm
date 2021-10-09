package com.atb.string;

/**
 * 暴力子字符串
 * Knuth-Morris-Pratt子字符串查找算法
 *
 * @Author 呆呆
 * @Datetime 2021/10/8 23:06
 */
public class KMP {

    private String pat;
    private int[][] dfa;
    public KMP(String pat){
        this.pat=pat;
        int M=pat.length();
        int R=256;
        dfa=new int[R][M];//需要回退的位数
        dfa[pat.charAt(0)][0]=1;
        for(int x=0,j=1;j<M;j++){
            for(int c=0;c<R;c++){
                dfa[c][j]=dfa[c][x];//复制匹配失败情况下的值
            }
            dfa[pat.charAt(j)][j]=j+1;//设置匹配成功情况下的值
            x=dfa[pat.charAt(j)][x];//更新重启状态
        }
    }

    public int search(String txt){
        int i,j,N=txt.length(),M=pat.length();
        for(j=0,i=0;i<N&&j<M;i++){
            j=dfa[txt.charAt(i)][j];
        }
        if(j==M) return i-M;    //找到匹配
        else return N;          //未找到匹配
    }

    //暴力子字符串查找
    public static int violenceSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) break;
            }
            if (j == M) return i;
        }
        return N;//未找到
    }

    //暴力子字符串查找 显示回退
    public static int violenceSearch_666(String pat, String txt) {
        int j, M = pat.length();
        int i, N = txt.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (txt.charAt(i) == pat.charAt(j)) j++;
            else {
                i -= j;
                j = 0;
            }
        }
        if (j == M) return i - M;//找到啦
        else return N;//未找到
    }
}
