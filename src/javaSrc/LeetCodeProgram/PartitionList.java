package javaSrc.LeetCodeProgram;

/**
 * @author Jim Wang
 * @create 2017-09-09 18:57
 **/
public class PartitionList {
    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(1);
        ListNode res = new PartitionList().partition(n, 0);
        while (res!= null){
            System.out.print(res.val    );
            res = res.next;
        }
    }
    /**
     * 题目描述

     Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
     You should preserve the original relative order of the nodes in each of the two partitions.
     For example,
     Given1->4->3->2->5->2and x = 3,
     return1->2->2->4->3->5.

     */
    public ListNode partition(ListNode head, int x) {
        if (head == null||head.next == null){
            return head;
        }
        ListNode p = head, left = new ListNode(0) ,right = new ListNode(0);
        ListNode l = left,r= right;

        while (p != null){
            if  (p.val < x){
                addNode(l, p.val);
                l = l.next;
            }else{
                addNode(r, p.val);
                r = r.next;
            }
            p = p.next ;
        }
        l.next = right.next;
        return left.next;
    }

    public void addNode(ListNode node, int val){
        if (node == null){
            node = new ListNode(val);
        }else{
            node.next = new ListNode(val);
        }
    }
}
