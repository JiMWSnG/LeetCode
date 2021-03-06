package javaSrc.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author jimwong
 * @since 2018/4/12  下午1:25
 */
public class MaximumSumOf3NonOverlappingSubarrays {
    /**
     *  In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.
     *
     * Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
     *
     * Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.
     *
     * Example:
     *
     * Input: [1,2,1,2,6,7,5,1], 2
     * Output: [0, 3, 5]
     * Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
     * We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
     *
     * Note:
     * nums.length will be between 1 and 20000.
     * nums[i] will be between 1 and 65535.
     * k will be between 1 and floor(nums.length / 3).
     */


    /***********
     ** right **    hard
     ***********/

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[][] dp = new int[4][nums.length + 1];
        int sum = 0;
        int[] accu = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            accu[i] = sum;
        }
        int[][] id = new int[4][nums.length + 1];
        int max = 0, inId = 0;
        for(int i = 1; i < 4; i++) {
            for(int j = i * k-1 ; j < nums.length; j++) {
                int tmpmax = j - k < 0 ? accu[j] : accu[j] - accu[j-k] + dp[i-1][j-k];
                // 推陈
                if(j - k >= 0) {
                    dp[i][j] = dp[i][j-1];
                    id[i][j] = id[i][j-1];
                }
                // 出新
                if(j > 0 && tmpmax > dp[i][j-1]) {
                    dp[i][j] = tmpmax;
                    id[i][j] = j-k+1;
                }
            }
        }
        int[] res = new int[3];
        res[2] = id[3][nums.length-1];
        res[1] = id[2][res[2] - 1];
        res[0] = id[1][res[1] - 1];
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,6,7,5,1};
        int[] res = new MaximumSumOf3NonOverlappingSubarrays().maxSumOfThreeSubarrays(nums, 2);
        for (int i :res){
            System.out.println(i);
        }

    }



}
