package javaSrc.LeetCode;

import java.util.ArrayList;

/**
 * Created by jiwang003746 on 2017/8/10.
 */
public class GrayCode {
    /**
     * 题目描述

     The gray code is a binary numeral system where two successive values differ in only one bit.
     Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
     For example, given n = 2, return[0,1,3,2]. Its gray code sequence is:
     00 - 0
     01 - 1
     11 - 3
     10 - 2
     Note:
     For a given n, a gray code sequence is not uniquely defined.
     For example,[0,2,3,1]is also a valid gray code sequence according to the above definition.
     For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
     */

    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<>();
       if (n < 0){
           return result;
       }
       result.add(0);
       for (int i = 0; i< n; i++){
           int size = result.size();
           for (int j = size - 1; j >= 0; j--){
               int temp = result.get(j);
               result.add(temp+(int)Math.pow(2, i));
           }
       }
       return result;

    }
}
