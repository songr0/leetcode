package main;

import main.domain.ListNode;

/**
 * 合并两个有序列表
 * @author Song Rui
 */
public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l2 == null){
            return l1;
        }
        if(l1 == null){
            return l2;
        }
        ListNode temp = l1.val < l2.val ? l1 : l2;
        ListNode head = temp;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        while(l1 != null){
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }
        while(l2 != null){
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }
        return head;
    }
}
