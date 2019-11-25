package javaSrc.LeetCode;

/**
 * @Author jimwong
 * @since 2019/9/16
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        getLongestPalindromicSubstring("bababd");
    }

    public static String getLongestPalindromicSubstring(String input) {
        int[][] D = new int[input.length()+1][input.length()+1];

        String output = "";
        //[j,k]
        for (int j = input.length() - 1; j >= 0; j--) {
            for (int k = j; k < input.length(); k++) {
                if (input.charAt(j) == input.charAt(k) && (k - j <= 2 ||D[j + 1][k - 1] == 1)) {
                        D[j][k] =1;
                        if (D[input.length()][input.length()] <k-j+1){
                            D[input.length()][input.length()] = k-j+1;
                            output = input.substring(j,k+1);
                        }
                }
            }
        }
        System.out.print(output);
        return output;

    }

}
