package javaSrc.LeetCode;

/**
 * Created by jiwang003746 on 2017/8/10.
 */
public class DecodeWays {
    /**
     * 题目描述
     * <p>
     * A message containing letters fromA-Zis being encoded to numbers using the following mapping:
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * Given an encoded message containing digits, determine the total number of ways to decode it.
     * For example,
     * Given encoded message"12", it could be decoded as"AB"(1 2) or"L"(12).
     * The number of ways decoding"12"is 2.
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int size = s.length();
        int[] dp = new int[size+1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; ++i) {
            dp[i] = (s.charAt(i - 1) == '0') ? 0 : dp[i - 1];
            if (i > 1 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
