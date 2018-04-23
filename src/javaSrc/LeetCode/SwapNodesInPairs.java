package javaSrc.LeetCode;

import javaSrc.util.ListNode;

import java.util.List;

/**
 * @Author jimwong
 * @since 2018/4/20  下午8:12
 */
public class SwapNodesInPairs {
    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     *
     * Example:
     *
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     *
     * Note:
     *
     *     Your algorithm should use only constant extra space.
     *     You may not modify the values in the list's nodes, only nodes itself may be changed.
     *
     */
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode newHead = head.next, a=head,b=a.next,pre = null;
        while(a!=null && b!=null){
            a.next = b.next;
            b.next = a;
            if(pre!=null) pre.next = b;
            if(a.next==null) break;
            b = a.next.next;
            pre = a;
            a = a.next;
        }
        return newHead;
    }
}
