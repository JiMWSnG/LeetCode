package javaSrc.SwardToOffer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiwang003746 on 2017/6/16.
 */
public class DeleteDuplication {
    /**
     *
     *删除链表中重复的结点
     *
     * 题目描述
     在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
     返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     */
    //头，尾要注意
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null||pHead.next==null){
            return pHead;
        }
        Map<Integer,Boolean> map = new HashMap<>();
        ListNode p = pHead;
        while(p!=null){
            if(map.get(p.val)==null)
                map.put(p.val,false);
            else
                map.put(p.val,true);
            p=p.next;

        }
        p=pHead;
        while(p!=null&&map.get(p.val)) {
            pHead = p.next;
            p.next=null;
            p=pHead;
        }
        while(p.next!=null){
            ListNode p1=p.next;
            if(!map.get(p1.val)){
                p=p.next;
            }else{
                p.next= p1.next;
                p1.next=null;
            }

        }
        return pHead;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
