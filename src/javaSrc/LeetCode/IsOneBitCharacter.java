package javaSrc.LeetCode;

/**
 * @Author jimwong
 * @since 2018/4/13  下午7:54
 */
public class IsOneBitCharacter {
    /**
     * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).
     *
     * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
     *
     * Example 1:
     *
     * Input:
     * bits = [1, 0, 0]
     * Output: True
     * Explanation:
     * The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
     *
     * Example 2:
     *
     * Input:
     * bits = [1, 1, 1, 0]
     * Output: False
     * Explanation:
     * The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
     *
     * Note:
     * 1 <= len(bits) <= 1000.
     * bits[i] is always 0 or 1.
     */

    /***********
     ** right **
     ***********/

    public  static boolean isOneBitCharacter(int[] bits) {
        int N = bits.length;
        int[] dp = new int[N + 1];
        dp[0] = 1;//   1/2 repersent 2bits
        dp[1] = bits[0];
        for (int i = 1; i < N; i++ ){
            int j = i+1;
            if (bits[i-1] == 0){
                dp[j] = bits[i];
            }else{
                dp[j] = (dp[j-1] + bits[i]) % 2;
            }
        }
        return dp[N] == 0;
    }

    public static void main(String[] args) {
        int[] bits = {1,1,1,0};
        System.out.println(isOneBitCharacter(bits));
    }
}
