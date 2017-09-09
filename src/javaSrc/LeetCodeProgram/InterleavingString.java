package javaSrc.LeetCodeProgram;

/**
 * @author Jim Wang
 * @create 2017-07-04 20:11
 **/
public class InterleavingString {
    public static void main(String[] args) {
        System.out.print(new InterleavingString().isInterleave("a", "b", "a"));
    }

    /**
     * 题目描述
     * <p>
     * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
     * For example,
     * Given:
     * s1 ="aabcc",
     * s2 ="dbbca",
     * When s3 ="aadbbcbcac", return true.
     * When s3 ="aadbbbaccc", return false
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int row = s1.length() + 1;
        int col = s2.length() + 1;
        int pag = s3.length();
        boolean result = false;
        if (row + col - 2 == pag) {
            boolean[][] dp = new boolean[row][col];
            //dp[i][j]表示s1(0~i-1)和s2(0~j-1)能成功匹配
            dp[0][0] = true;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i != 0 && s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                    if (j != 0 && s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
                        dp[i][j] |= dp[i][j - 1];
                    }
                }
            }

            for (int i = 0; i < row; i++) {
                int j = pag - i;
                if (j < col) {
                    result |= dp[i][pag - i];
                }
            }
        }
        return result;
    }
}
