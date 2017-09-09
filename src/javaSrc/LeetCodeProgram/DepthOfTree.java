package javaSrc.LeetCodeProgram;

/**
 * @author Jim Wang
 * @create 2017-07-02 13:22
 **/
public class DepthOfTree {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
        TreeNode(int x) { val = x; }
     }
    /**
     *
     * maximum-depth-of-binary-tree
     * 题目描述

     Given a binary tree, find its maximum depth.
     The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     */
    public int maxDepth(TreeNode root) {
        if(root ==null ){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int leftH = 0;
        if (root.left != null){
            leftH = maxDepth(root.left)+1;
        }
        int rightH = 0;
        if (root.right != null){
            rightH = maxDepth(root.right)+1;
        }
        return (leftH> rightH)? leftH : rightH;
    }
}
