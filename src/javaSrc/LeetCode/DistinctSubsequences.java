package javaSrc.LeetCode;

/**
 * Created by jiwang003746 on 2017/6/23.
 */
public class DistinctSubsequences {
    public static void main(String[] args) {
        String a = "123";
        String b = a.substring(3);
        int num = new DistinctSubsequences().matchString("rabbbit", "rabbit");
        System.out.print(num);
    }
    /**
     *
     * 题目描述

     Given a string S and a string T, count the number of distinct subsequences of T in S.
     A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
     of the characters without disturbing the relative positions of the remaining characters. (ie,"ACE"is a subsequence of"ABCDE"while"AEC"is not).
     Here is an example:
     S ="rabbbit", T ="rabbit"
     Return3.
     */
    /**
    *  思路：dp题。
    *  状态定义：dp[i][j]代表s[0~i-1]中T[0~j-1]不同子串的个数。
    *  递推关系式：S[i-1]!= T[j-1]：  DP[i][j] = DP[i-1][j] （不选择S中的s[i-1]字符）
    *              S[i-1]==T[j-1]： DP[i][j] = DP[i-1][j-1]（选择S中的s[i-1]字符） + DP[i-1][j]
    *  初始状态：第0列：DP[i][0] = 1，第0行：DP[0][j] = 0
    */
    public int numDistinct(String S, String T) {
        return matchString(S,T);
    }
    private int matchString(String s, String t){
        int row = s.length()+1;
        int col = t.length()+1;
        int[][] dp = new int [row][col];
        //t == "" 的情况
        for(int i = 0; i < row; i++){
            dp[i][0] = 1;
        }
        //s == "" 和s == t == "" 的情况，但是为什么是1
        for (int j = 1; j < col; j++){
            dp[0][j] = 0;
        }
        for (int i = 1; i< row; i++){
            for (int j = 1; j <col; j++){
                dp[i][j] = dp[i-1][j];
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[row-1][col-1];

    }


}
