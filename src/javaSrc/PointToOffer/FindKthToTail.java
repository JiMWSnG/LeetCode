package javaSrc.PointToOffer;

import java.util.List;

/**
 * Created by Jim Wang on 2017/4/20.
 */
public class FindKthToTail {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
    }

    }

    /**
     /**
     * 合并两个排序的链表
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     * /
     */
    public ListNode Merge(ListNode list1, ListNode list2){
        if(list1==null)
            return list2;
        if(list2== null)
            return list1;
        ListNode result ;
        if(list1.val<list2.val){
            result = list1;
            list1 = list1.next;
        }

        else{
            result = list2;
            list2= list2.next;
        }
        ListNode tmp=result;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                tmp.next = list1;
                tmp = list1;
                list1 = list1.next;
            }

            else{
                tmp.next = list2;
                tmp =list2;
                list2= list2.next;
            }

        }
        if(list1 ==null){
            tmp.next = list2;
        }
        if(list2 ==null)
            tmp.next = list1;
        return result;

    }



    /**
     * 反转链表
     *输入一个链表，反转链表后，输出链表的所有元素。
     * * @param root
     * @return
     */
    public ListNode ReverseList(ListNode root){
        if(root ==null ||root.next ==null)
            return root;
        ListNode newRoot = null;
        while(root.next!=null){
            ListNode tmp = root.next;
            root.next = newRoot;
            newRoot = root;
            root = tmp;


        }
        root.next = newRoot;
        return root;


    }


    /**
     * 链表中倒数第k个结点
     *
     * 输入一个链表，输出该链表中倒数第k个结点。
     * k=0时输出空；
     */

    public ListNode FindKthToTail(ListNode head,int k ){
        if(head==null||k<=0)
            return null;
        ListNode p1=head;
        ListNode p2=head;
        for(int i =1;i<k;i++){
            if(p2.next==null)
                return null;
            p2 = p2.next;
        }
        while(p2.next!=null){
            p1 = p1.next;
            p2= p2.next;
        }
        return p1;

    }

    public static void main(String[] args) {

    }
}
