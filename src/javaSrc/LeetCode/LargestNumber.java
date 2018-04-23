package javaSrc.LeetCode;

import java.util.*;

/**
 * @Author jimwong
 * @since 2018/4/17  上午10:36
 */
public class LargestNumber {
    /**
     * Given a list of non negative integers, arrange them such that they form the largest number.
     *
     * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
     *
     * Note: The result may be very large, so you need to return a string instead of an integer.
     *
     * Credits:
     * Special thanks to @ts for adding this problem and creating all test cases.
     */

    /***********
     ** right **
     ***********/

    public static void main(String[] args) {
        int[] nums = {0,0};
        System.out.println(new LargestNumber().largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        List<Integer> a = new ArrayList<>();
        for (int i : nums){
            a.add(i);
        }
        Collections.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String aStr = String.valueOf(o1);
                String bStr = String.valueOf(o2);
                return compareTheFirst(aStr, bStr);
            }
        });
        while (a.size() != 0 && a.get(a.size() - 1) == 0){
            a.remove(a.size() - 1);
        }

        return parese(a);

    }

    private String parese(List<Integer> list){
        if (list == null || list.size() == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--){
            sb.append(list.get(i));
        }
        return sb.toString();
    }



    private int compareTheFirst(String aStr, String bStr){
        int i = 0;
        int aN = aStr.length();
        int bN = bStr.length();
        while (i < aN && i < bN){
            if (aStr.charAt(i) > bStr.charAt(i)){
                return 1;
            }
            if (aStr.charAt(i) < bStr.charAt(i)){
                return -1;
            }
            if (aStr.charAt(i) == bStr.charAt(i)){
                i++;
            }
        }
        if (aN == bN){
            return 0;
        }
        return aN < bN ? compareTheFirst(aStr, bStr.substring(i, bN))
                : compareTheFirst(aStr.substring(i, aN), bStr);


    }
}
