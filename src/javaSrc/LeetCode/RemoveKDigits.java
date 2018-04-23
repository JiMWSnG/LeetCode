package javaSrc.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author jimwong
 * @since 2018/4/18  下午7:02
 */
public class RemoveKDigits {
    /**
     *  Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
     *
     * Note:
     *
     *     The length of num is less than 10002 and will be ≥ k.
     *     The given num does not contain any leading zero.
     *
     * Example 1:
     *
     * Input: num = "1432219", k = 3
     * Output: "1219"
     * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
     *
     * Example 2:
     *
     * Input: num = "10200", k = 1
     * Output: "200"
     * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
     *
     * Example 3:
     *
     * Input: num = "10", k = 2
     * Output: "0"
     * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
     */

    /***********
     ** right ** 在其位谋其事，保证自己前面没有比我大的数字
     ***********/

    public String removeKdigits(String num, int k) {
        int digits = num.length() - k;
        char[] stk = new char[num.length()];
        int top = 0;
        // k keeps track of how many characters we can remove
        // if the previous character in stk is larger than the current one
        // then removing it will get a smaller number
        // but we can only do so when k is larger than 0
        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (top > 0 && stk[top-1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            stk[top++] = c;
        }
        // find the index of first non-zero digit
        int idx = 0;
        while (idx < digits && stk[idx] == '0') idx++;
        return idx == digits? "0": new String(stk, idx, digits - idx);
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
//        for (int i = 0; i < 100; i++){
//            a.add(i);
//        }

        Map<Boolean, List<Integer>> map = a.stream().collect(Collectors.partitioningBy( b -> b > 100));
        if  (map.get(false).size() == 0){
            System.out.println(true);
        }else  {
            System.out.println(false);

        }
    }
}
