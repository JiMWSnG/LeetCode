package javaSrc.LeetCode;

public class ReverseBits {
    /**
     * Reverse bits of a given 32 bits unsigned integer.
     *
     * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
     *
     * Follow up:
     * If this function is called many times, how would you optimize it?
     *
     * Related problem: Reverse Integer
     *
     * Credits:
     * Special thanks to @ts for adding this problem and creating all test cases.
     */

    /***********
     ** right **
     ***********/
    public static int reverseBits(int n){
        int i = 31;
        int bit = 0;
        int result = 0;
        while (n != 0 || i == 0){
            bit = n & 1;
            result += bit<<i--;
            // 注意：这里要使用无符号右移
            n = n>>>1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(Integer.MAX_VALUE+1));
        System.out.print(Integer.MAX_VALUE+1);// 溢出




    }
}
