package javaSrc.LeetCode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Jim Wang
 * @create 2017-07-02 13:31
 **/
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class TraversalTree {

    /**
     * binary-tree-zigzag-level-order-traversal
     * 题目描述

     Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
     For example:
     Given binary tree{3,9,20,#,#,15,7},
     3
     / \
     9  20
     /  \
     15   7

     return its zigzag level order traversal as:
     [
     [3],
     [20,9],
     [15,7]
     ]
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        new TraversalTree().zigzagLevelOrder(root);

    }
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack[] stack  = new Stack[2];
        stack[0] = new Stack<TreeNode>();
        stack[1] = new Stack<TreeNode>();
        if(root == null){
             return   new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int order = 0;
        stack[order].push(root);
        while(!stack[0].empty() || !stack[1].empty()){
            ArrayList<Integer> list = new ArrayList<>();
            while(!stack[order].empty()){
                TreeNode node = (TreeNode)stack[order].pop();
                list.add(node.val);
                if(order == 0 ){
                    if(node.left != null){
                        stack[(order+1)%2].push(node.left);
                    }
                    if(node.right != null){
                        stack[(order+1)%2].push(node.right);
                    }
                }else{
                    if(node.right != null){
                        stack[(order+1)%2].push(node.right);
                    }
                    if(node.left != null){
                        stack[(order+1)%2].push(node.left);
                    }
                }

            }
            result.add(list);
            order =(order+1)%2;

        }
        return result;

    }
}
