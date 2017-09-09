package javaSrc.LeetCodeProgram;


import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by jiwang003746 on 2017/6/22.
 */
public class NextPointer {
    public static void main(String[] args) {
        NextPointer a = new NextPointer();
     TreeLinkNode root =  a.new TreeLinkNode(0);
     a.connect(root);

    }

      //Definition for binary tree with next pointer.
      public class TreeLinkNode {
          int val;
          TreeLinkNode left, right, next;
          TreeLinkNode(int x) { val = x; }
      }
    /**
     * populating-next-right-pointers-in-each-node
     *
     * 题目描述

     Given a binary tree
     struct TreeLinkNode {
     TreeLinkNode *left;
     TreeLinkNode *right;
     TreeLinkNode *next;
     }

     Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set toNULL.
     Initially, all next pointers are set toNULL.
     Note:
     You may only use constant extra space.
     You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

     For example,
     Given the following perfect binary tree,
     1
     /  \
     2    3
     / \  / \
     4  5  6  7

     After calling your function, the tree should look like:
     1 -> NULL
     /  \
     2 -> 3 -> NULL
     / \  / \
     4->5->6->7 -> NULL
     */

    public void connect(TreeLinkNode root) {
        if(root == null){
            return ;
        }
        boolean empty = false;
        Queue<TreeLinkNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        int i =0;int h =0;
        while(!empty){
           TreeLinkNode node = queue.poll();
           if(node == null){
               empty=true;
           }else{
               if(node.left != null || node.right != null){
                   queue.offer(node.left);
                   queue.offer(node.right);
               }
               if(i<Math.pow(2,h)-1){
                   node.next = queue.peek();
               }
               i = (i+1)%(int)Math.pow(2,h);
               if(i == 0){
                   h++;
               }
           }
        }
    }


    /**
     * 题目描述

     Follow up for problem "Populating Next Right Pointers in Each Node".
     What if the given tree could be any binary tree? Would your previous solution still work?
     Note:
     You may only use constant extra space.

     For example,
     Given the following binary tree,
     1
     /  \
     2    3
     / \    \
     4   5    7

     After calling your function, the tree should look like:
     1 -> NULL
     /  \
     2 -> 3 -> NULL
     / \    \
     4-> 5 -> 7 -> NULL
     */

    public void connect2(TreeLinkNode root) {
        if(root == null){
            return ;
        }
        Queue<TreeLinkNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        int h =1;
        while(h != 0){
            int num = 0;
            for(int i =0;i<h;i++){
                TreeLinkNode node = queue.poll();
                if(node.left != null ){
                    queue.offer(node.left);
                    num++;
                }
                if(node.right != null){
                    queue.offer(node.right);
                    num++;
                }
                if(i<h-1){
                    node.next = queue.peek();
                }

            }
            h =num;
        }

    }

    //best最优的
    public void connect3(TreeLinkNode root) {
        if(root == null)
            return;
        TreeLinkNode dummy = new TreeLinkNode(-1);
        TreeLinkNode cur;
        TreeLinkNode prev = dummy;
        for(cur=root; cur !=null; cur = cur.next){
            if(cur.left !=null)
            {
                prev.next = cur.left;
                prev = prev.next;
            }
            if(cur.right !=null){
                prev.next = cur.right;
                prev = prev.next;
            }
        }
        connect(dummy.next);
    }

}
