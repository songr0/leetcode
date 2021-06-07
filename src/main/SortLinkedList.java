package main;

import main.domain.ListNode;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * @author Song Rui
 */
public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // 考虑快速排序，归并排序等
        // 先找到中间节点，两边分段排序，最后合并
        ListNode middle = findMiddle(head);
        ListNode l2 = middle.next;
        middle.next = null;
        return mergeTwoList(sortList(head), sortList(l2));
    }

    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        } else if(l2 == null){
            return l1;
        } else if(l1.val <= l2.val){
            // 自底向上
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,1,2,3);
        ListNode head = ListNode.buildLinkedList(list);
        head = new SortLinkedList().sortList(head);
        Assert.assertNotNull(head);
    }


}
