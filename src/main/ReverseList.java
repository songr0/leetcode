package main;

import main.domain.ListNode;

/**
 * @author Song Rui
 */
public class ReverseList {

    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = head;
        ListNode pre = null;
        ListNode next = head.next;
        while(true){
            mid.next = pre;
            if(next == null){
                break;
            }
            pre = mid;
            mid = next;
            next = next.next;
        }
        return mid;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        new ReverseList().ReverseList(a);
        while (e != null) {
            System.out.print(e.val);
            e = e.next;
        }
    }

}
