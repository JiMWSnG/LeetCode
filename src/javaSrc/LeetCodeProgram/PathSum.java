package javaSrc.LeetCodeProgram;

import java.util.ArrayList;

/**
 * Created by Jim Wang on 2017/6/25.
 */
public class PathSum {
    /**
     *
     * 题目描述

     Given a binary tree and a sum, determine
     if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
     For example:
     Given the below binary tree andsum = 22,
     5
     / \
     4   8
     /   / \
     11  13  4
     /  \      \
     7    2      1
     return true, as there exist a root-to-leaf path5->4->11->2which sum is 22.
     */
     public class TreeNode {
       int val;
         TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }
    public boolean hasPathSum(TreeNode root, int sum){
        if(root == null){
            return false;
        }
       return sum(root, 0, sum);
    }
    //dfs
    private boolean sum(TreeNode root, int sum, int n){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return (sum+root.val) == n;

        }
        boolean result =false;
        if(root.left != null){
            result = sum(root.left,sum+root.val,n);
        }
        if(root.right != null){
            result |= sum(root.right, sum+root.val, n);
        }
        return result;
    }

    /**
     *
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
     For example:
     Given the below binary tree andsum = 22,
     5
     / \
     4   8
     /   / \
     11  13  4
     /  \    / \
     7    2  5   1
     return
     [
     [5,4,11,2],
     [5,8,4,5]
     ]
     */
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        sum(root, result, new ArrayList<Integer>(), 0, sum);
        return result;
    }
    private void sum(TreeNode root, ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path, int n, int sum){
        if(root == null){
            return ;
        }
        if(root.left == null && root.right == null){
            if((n+root.val) == sum){
                path.add(root.val);
                paths.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);
            }
            return ;
        }
        if(root.left != null){
            path.add(root.val);
            sum(root.left, paths, path, n+root.val, sum);
            path.remove(path.size()-1);
        }
        if(root.right != null){
            path.add(root.val);
            sum(root.right, paths, path, n+root.val, sum);
            path.remove(path.size()-1);
        }
    }

}
