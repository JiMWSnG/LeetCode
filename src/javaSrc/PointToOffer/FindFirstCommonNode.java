package javaSrc.PointToOffer;

/**
 * Created by Jim Wang on 2017/6/1.
 */
public class FindFirstCommonNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    /**
     *两个链表的第一个公共节点
     *  *
     * 题目描述
     输入两个链表，找出它们的第一个公共结点。(不考虑环的情况)
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null)
            return null;
        ListNode p1 = pHead1;
        int len1=1;
        while(p1.next!=null){
            p1=p1.next;
            len1++;
        }
        ListNode p2 = pHead2;
        int len2=1;
        while(p2.next!=null){
            p2=p2.next;
            len2++;
        }

        if(p1!=p2)
            return null;

        p1=pHead1;
        p2 = pHead2;
        if(len1>len2){

            for(int i =0;i<len1-len2;i++)
                p1=p1.next;
        }else{
            for(int i =0;i<len2-len1;i++)
                p2=p2.next;
        }
        while(p1!=p2){
            p1=p1.next;
            p2= p2.next;
        }
        return p1;



    }

}
