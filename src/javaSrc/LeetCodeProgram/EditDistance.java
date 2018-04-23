package javaSrc.LeetCodeProgram;

/**
 * @author Jim Wang
 * @create 2017-10-08 14:33
 **/
public class EditDistance {
    /**
     * 题目描述

     Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
     You have the following 3 operations permitted on a word:
     a) Insert a character
     b) Delete a character
     c) Replace a character
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2){
        if (word1 == null || word2 == null )
            return -1;
        int s = word1.length();
        int t = word2.length();
        int[][] dp = new int[s+1][t+1];
        for (int i = 0; i<= s;i++){
            dp[i][0] = i;
        }
        for ( int j = 1; j <= t; j++){
            dp[0][j] = j;
        }
        for (int i = 1; i<= s; i++){
            for(int j = 1; j<= t;j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1])+1;
                }
            }
        }
        return dp[s][t];
    }
}
