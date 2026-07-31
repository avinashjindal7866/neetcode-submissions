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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode secondHalf = slow;
        ListNode trail = null;

        while(secondHalf != null){
            ListNode curr = secondHalf.next;
            secondHalf.next = trail;
            trail = secondHalf;
            secondHalf = curr;
        }
        while(trail != null){
            System.out.println(head.val + " " + trail.val);
            if(head.val == trail.val){
                head = head.next;
                trail = trail.next;
            }else{
                return false;
            }
        }
        return true;
    }
}