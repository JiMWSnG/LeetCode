package javaSrc.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * Example:
     *
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */

    /***********
     ** right **
     ***********/
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> location = new HashMap<>();
        int[] result = new int[2];
        int size = nums.length;
        for (int i = 0; i < size; i++){
            int cur = nums[i];
            if (location.containsKey(cur)){
                result[0] = location.get(cur);
                result[1] = i;
                return result;
            }else{
                location.put(target-cur, i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 17};
        int[] res = twoSum(nums, 9);
        System.out.print("["+res[0]+" "+res[1]+"]");
    }
}
