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
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = null;
        ListNode newTrail = null;

        while(head != null){
            if(head.val == val){
                head = head.next;
            }else{
                if(newHead == null){                    
                    newHead = head;
                    newTrail = head;
                    head = head.next;
                }else{
                    ListNode curr = head.next;
                    newTrail.next = head;
                    newTrail = newTrail.next;
                    newTrail.next = null;
                    head = curr;
                }
            }
        }

        return newHead;
    }
}