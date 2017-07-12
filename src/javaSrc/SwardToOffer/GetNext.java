package javaSrc.SwardToOffer;

import sun.reflect.generics.tree.Tree;

/**
 * Created by jiwang003746 on 2017/6/16.
 */
public class GetNext {
    /**
     *
     * 二叉树的下一个结点
     *
     * 题目描述
     给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     */

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {

        if(pNode==null)
            return null;
        TreeLinkNode next = null;
        if(pNode.right==null){
            TreeLinkNode parent = pNode.next;
            while(parent!=null&&pNode==parent.right){
                pNode=parent;
                parent =pNode.next;
            }
            next =parent;
        }else{
            //mid order list
            next= midOrderFirst(pNode.right);
        }
        return next;
    }

    private TreeLinkNode midOrderFirst(TreeLinkNode root){
        if(root==null){
            return root;
        }
        TreeLinkNode first =null;
        if(root.left!=null){
            first = midOrderFirst(root.left);
        }else{
            first =root;
        }
        return first;
    }


    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
