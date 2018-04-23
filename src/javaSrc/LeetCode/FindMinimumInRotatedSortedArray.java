package javaSrc.LeetCode;

/**
 * @Author jimwong
 * @since 2018/4/10  下午5:36
 */
public class FindMinimumInRotatedSortedArray {

    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     *
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     *
     * Find the minimum element.
     *
     * You may assume no duplicate exists in the array.
     */

    /***********
     ** right **
     ***********/
    public int findMin(int[] nums) {
        int cur = nums[0];
        for (int i : nums){
            if (i >= cur){
                cur = i;
            }else{
                return i;
            }
        }
        return nums[0];
    }
}
