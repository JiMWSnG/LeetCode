package javaSrc.LeetCode;

import java.util.*;

/**
 * @Author jimwong
 * @since 2018/4/17  下午5:32
 */
public class IntersectionOfTwoArrays {
    /**
     *  Given two arrays, write a function to compute their intersection.
     *
     * Example:
     * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
     *
     * Note:
     *
     *     Each element in the result must be unique.
     *     The result can be in any order.
     */


    /***********
     ** right **
     ***********/
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums1){
            if (!map.containsKey(i)){
                map.put(i, true);
            }
        }
        for (int i : nums2){
            if (map.containsKey(i)){
                set.add(i);
            }
        }
        int[] result = new int[set.size()];
        int j = 0;
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()){
            result[j++] = it.next();
        }
        return result;
    }

}
