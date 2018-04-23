package javaSrc.LeetCodeProgram;

/**
 * @author Jim Wang
 * @create 2017-10-01 15:33
 **/
public class RemoveDupNodeii {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tmp = new ListNode(1);
        head.next = tmp;
        ListNode tmp2 = new ListNode(2);
        tmp.next = tmp2;
        tmp = new ListNode(3);
        tmp2.next = tmp;
        tmp2 = new ListNode(3);
        tmp.next = tmp2;

        ListNode re = deleteDuplicates(head);
        while (re != null){
            System.out.println(re.val   );
            re = re.next;
        }
    }
    public static  ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode cur = head, last = result;
        while(cur != null){
            while( cur.next != null && cur.next.val == cur.val){
                cur = cur.next;
            }

            last.next = cur;
            last =cur;
            cur = cur.next;

        }

        return result.next;
    }
}
