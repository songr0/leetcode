package main.domain;

import java.util.List;

/**
 * @author Song Rui
 */
public class ListNode {
     public int val;
     public ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     public static ListNode buildLinkedList(List<Integer> list){
         if(list == null || list.isEmpty()){
             return null;
         }
         ListNode head = new ListNode();
         ListNode temp = new ListNode(list.get(0));
         head.next = temp;
         int len = list.size();
         for(int i =1;i < len;++i){
             temp.next = new ListNode(list.get(i));
             temp = temp.next;
         }
         return head.next;
     }
 }