package javaSrc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jim Wang on 2017/3/24.
 */
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode==null){
            return new ArrayList<Integer>();
        }
        if(listNode.next==null){
            return new ArrayList<Integer>(listNode.val);
        }
        ListNode pre = listNode;

        ListNode pro =listNode.next;
        pre.next =null;
        while(pro!=null){
            ListNode tmp = pro.next;
            pro.next =pre;
            pre = pro ;
            pro = tmp;
        }
        ArrayList<Integer> tailToHead =new ArrayList<>();
        while(pre!=null){
            tailToHead.add(pre.val);
            pre = pre.next;

        }
        return tailToHead;
    }
}
