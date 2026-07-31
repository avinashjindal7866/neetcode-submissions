/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode tail = null;
        while(list1 != null && list2 != null){
            if(list2.val > list1.val){
                if(head == null){
                    head = list1;
                    tail = list1;
                    list1 = list1.next;
                }else{
                   ListNode temp = list1;
                    tail.next = temp;
                    tail = tail.next;
                    list1 = list1.next;
                }
            }else{
                if(head == null){
                    head = list2;
                    tail = list2;
                    list2 = list2.next;
                }else{
                    ListNode temp = list2;
                    tail.next = temp;
                    tail = tail.next;
                    list2 = list2.next;
                }
            }
        }

        if(list1 != null){
            if(head != null){
                tail.next = list1;
            }else{
                head = list1;
            }
        }
        if(list2 != null){
            if(head != null){
                tail.next = list2;
            }else{
                head = list2;
            }
        }
        return head;
    }
}