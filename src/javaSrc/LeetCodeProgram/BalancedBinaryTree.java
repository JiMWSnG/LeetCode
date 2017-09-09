package javaSrc.LeetCodeProgram;

/**
 * Created by jiwang003746 on 2017/6/26.
 */
public class BalancedBinaryTree {

    //Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     *
     * 题目描述

     Given a binary tree, determine if it is height-balanced.
     For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean[] isBalanced = new boolean[1];
        isBalanced[0] = true;
        afterOrderHeight(root, isBalanced);
        return isBalanced[0];

    }
    private int afterOrderHeight(TreeNode root ,boolean[] isBalanced){
        if(root == null){
            return 0;
        }
        int hl = 0;
        int hr = 0;
        if(root.left != null){
            hl = afterOrderHeight(root.left,isBalanced);
        }
        if(root.right != null){
            hr = afterOrderHeight(root.right,isBalanced);
        }
        if(Math.abs(hl-hr)>=2){
            isBalanced[0] &= false;
        }
        return hl>hr?hl+1:hr+1;
    }
}
