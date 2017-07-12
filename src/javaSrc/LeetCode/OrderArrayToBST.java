package javaSrc.LeetCode;

/**
 * Created by jiwang003746 on 2017/6/27.
 */
public class OrderArrayToBST {
    /**
     * 题目描述

     Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if(num ==null || num.length == 0){
            return null;
        }
        return halfSearch(num, 0,num.length);

    }
    //[bengin,end)
    private TreeNode halfSearch(int[] nums, int begin, int end){
        if(begin>=end){
            return null;
        }
        int mid = (begin+end)>>1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = halfSearch(nums, begin, mid);
        root.right = halfSearch(nums, mid+1,end);
        return root ;
    }
}
