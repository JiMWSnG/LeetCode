package javaSrc.LeetCodeProgram;

/**
 * Created by jiwang003746 on 2017/6/26.
 */
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
public class OrderedSingleListToBinarySearchTree {
     //Definition for binary tree


    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        new OrderedSingleListToBinarySearchTree().sortedListToBST(head);

    }
    /**
     * 题目描述

     Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head){
        if(head == null){
            return null;
        }
        //TreeNode root = new TreeNode(head.val);
         return buildBinarySearchTree(head);
    }

    private TreeNode buildBinarySearchTree(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode mid =null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode tmp = null;
        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            tmp = slow;
            slow = slow.next;

        }
        if(tmp == null){
            head = null;
        }else{
            tmp.next = null;
        }
        mid = slow;
        if(mid != null){
            TreeNode root = new TreeNode(mid.val);
            root.left = buildBinarySearchTree(head);
            root.right = buildBinarySearchTree(mid.next);
            return root;
        }
        return null;

    }

}
