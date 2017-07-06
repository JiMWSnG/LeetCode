package javaSrc.LeetCode;

/**
 * Created by jiwang003746 on 2017/6/30.
 */


public class ConstructBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        int[] in = {1,2};
        int[] post = {2,1};
        new ConstructBinaryTree().buildTree(in, post);
        return ;
    }
    /**
     * 题目描述

     Given inorder and postorder traversal of a tree, construct the binary tree.
     Note:
     You may assume that duplicates do not exist in the tree.
     */
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null){
            return null;
        }
        if(inorder.length == 0 && inorder.length == postorder.length)
            return null;
        if(inorder.length != postorder.length)
            return null;
        return constructTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
   // [s, e)
    private TreeNode constructTree(int[] inorder, int s1, int e1, int[] postorder, int s2, int e2){
        if(e1-s1 == 0 || e2 - s2 == 0)
            return null;
        TreeNode root = new TreeNode(postorder[e2-1]);
        int mid = -1;
        for(int i = s1; i<e1; i++){
           if( inorder[i] == postorder[e2-1])
               mid = i;
        }
        root.left = constructTree(inorder, s1, mid, postorder, s2, s2+mid-s1);
        root.right = constructTree(inorder, mid+1, e1, postorder, s2+mid-s1, e2-1);
        return root;

    }


    /**
     * 题目描述

     Given preorder and inorder traversal of a tree, construct the binary tree.
     Note:
     You may assume that duplicates do not exist in the tree.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder == null || preorder == null){
            return null;
        }
        if(inorder.length == 0 && inorder.length == preorder.length)
            return null;
        if(inorder.length != preorder.length)
            return null;
        return constructBinaryTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode constructBinaryTree(int[] pre, int s1, int e1, int[] in, int s2, int e2){
        if(e1-s1 == 0 || e2 - s2 == 0)
            return null;
        TreeNode root = new TreeNode(pre[s1]);
        int mid = -1;
        for(int i = s2; i<e2; i++){
            if( in[i] == pre[s1])
                mid = i;
        }
        root.left = constructBinaryTree(pre, s1+1, s1+1+mid-s2, in, s2, mid);
        root.right = constructBinaryTree(pre, s1+1+mid-s2, e1, in, mid+1, e2);
        return root;
    }
}
