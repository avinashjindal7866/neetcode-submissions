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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode tem1 = l1;
        ListNode tem2 = l2;

        int carry = 0;

        while(tem1 != null){
            int sum = tem1.val + carry;
            
            if(tem2 != null){
                sum += tem2.val;
                tem2 = tem2.next;
                
            }
            System.out.println(sum);
            tem1.val = sum % 10;
            carry = sum / 10;

          
            if (tem1.next == null && tem2 != null) {
                tem1.next = tem2;
                tem2 = null;
            }

            tem1 = tem1.next;
        }

        if (carry > 0) {
            ListNode temp1 = l1;

            while (temp1.next != null) {
                temp1 = temp1.next;
            }

            
            temp1.next = new ListNode(carry);
                

        }



        return l1;
    }
}
