package javaSrc.LeetCodeProgram;

import java.util.Arrays;

/**
 * @author Jim Wang
 * @create 2017-10-09 22:58
 **/
public class PlusOne {
    /**
     * 题目描述
     * <p>
     * Given a number represented as an array of digits, plus one to the number.
     */
    public static void main(String[] args) {
        int[] d = {0};
        for (Integer i : plusOne(d)) {
            System.out.println(i);
            System.out.println(",");
        }
    }

    //大数
    public static int[] plusOne(int[] digits) {
        if (digits == null) {
            return digits;
        }
        int c = 1;
        for (int i = digits.length-1; i >=0 ; i--) {
            int n = digits[i];
            if (n == 9 && c==1) {
                digits[i] = 0;
                c = 1;
            } else {
                digits[i] = n + c;
                c = 0;
            }
        }
        if (c==1){
            int[] result = new int[digits.length+1];
            System.arraycopy(digits, 0,result, 1, result.length-1);
            result[0] =c;
            return result;
        }
        return digits;
    }
}
