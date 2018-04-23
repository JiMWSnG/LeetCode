package javaSrc.LeetCode;

import javaSrc.util.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * @Author jimwong
 * @since 2018/4/16  下午7:07
 */
public class AddTwoNumbers {
    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Example
     *
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     */


    /***********
     ** right **
     ***********/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        // 这个循环写得很nice
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;// 画龙点睛
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;

    }


    /**
     * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Follow up:
     * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
     *
     * Example:
     *
     * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 8 -> 0 -> 7
     */


    /***********
     ** right **
     ***********/
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode p = l1;
        ListNode q = l2;

        while (p != null){
            stack1.push(p.val);
            p = p.next;
        }
        while (q != null){
            stack2.push(q.val);
            q = q.next;
        }
        int c = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = a + b + c;
            int val = sum % 10;
            c = sum / 10;
            p = new ListNode(val);
            p.next = q;
            q = p;
        }
        if (c != 0){
            p = new ListNode(c);
            p.next = q;
        }
        return p;
    }
}
