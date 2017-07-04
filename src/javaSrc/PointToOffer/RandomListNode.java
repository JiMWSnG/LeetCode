package javaSrc.PointToOffer;

import java.util.Random;

/**
 * Created by Jim Wang on 2017/5/2.
 */
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }

    public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode tmp = cloneNode(pHead);
        tmp = cloneRandomPoint(tmp);
        return reconnectList(tmp);
    }
    private RandomListNode cloneNode(RandomListNode pHead){
        RandomListNode p1 = pHead;
        while(p1!=null){
            RandomListNode tmp = new RandomListNode(p1.label);
            tmp.next = p1.next;
            p1.next = tmp;
            p1 = tmp.next;
        }
        return pHead;
    }
    private RandomListNode cloneRandomPoint(RandomListNode pHead){
        RandomListNode p1 = pHead;
        RandomListNode p2 =null;

        while(p1!=null){
            p2 = p1.next;
            if(p1.random!=null)
                 p2.random = p1.random.next;
            else
                p2.random = null;
            p1 = p2.next;
        }
        return pHead;

    }
    private RandomListNode reconnectList(RandomListNode pHead){
        if(pHead==null)
            return null;
        RandomListNode p1 = pHead;
        RandomListNode result = pHead.next;
        RandomListNode p2 = null;
        while(p1!=null){
            p2 = p1.next;
            p1.next = p2.next;
            if(p2.next!=null)
                p2.next = p2.next.next;

            p1=p1.next;
            p2 = p2.next;


        }
        return result;
    }
}
