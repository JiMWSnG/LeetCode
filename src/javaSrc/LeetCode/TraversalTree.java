package javaSrc.LeetCode;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by jiwang003746 on 2017/6/27.
 */
public class TraversalTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        ArrayList<ArrayList<Integer>> result = new TraversalTree().levelOrderBottom(root);
    }
    /**
     *
     *
     题目描述

     Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
     For example:
     Given binary tree{3,9,20,#,#,15,7},
     3
     / \
     9  20
     /  \
     15   7

     return its bottom-up level order traversal as:
     [
     [15,7]
     [9,20],
     [3],
     ]

     confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.

     OJ's Binary Tree Serialization:
     The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
     Here's an example:
     1
     / \
     2   3
     /
     4
     \
     5
     The above binary tree is serialized as"{1,2,3,#,#,4,#,#,5}".
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode>[] queue = new LinkedList[2];
        queue[0] = new LinkedList<>();
        queue[1] = new LinkedList<>();
        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
        queue[0].offer(root);
        queue[1].peek();
        levelOrder(nodes, queue);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i = nodes.size()-1; i>=0; i--){
            result.add(nodes.get(i));
        }
        return result;
    }
    private void levelOrder( ArrayList<ArrayList<Integer>> nodes, Queue<TreeNode>[] queue){

        TreeNode node = null;
        int index =0;
        while(queue[0].peek() != null  || queue[1].peek() !=null){
            ArrayList<Integer> levelNode = new ArrayList<>();
            while (( node = queue[index].poll() ) !=null){
                if(node.left != null)
                    queue[(index+1)%2].offer(node.left);
                if(node.right != null)
                  queue[(index+1)%2].offer(node.right);
                levelNode.add(node.val);
            }
            nodes.add(levelNode);
            index = (index+1)%2;
        }

    }
}
