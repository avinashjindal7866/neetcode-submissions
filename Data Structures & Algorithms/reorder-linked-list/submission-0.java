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
    public void reorderList(ListNode head) {
        List<Integer> arrayList = new ArrayList<>();
        convertToList(head,arrayList);
        System.out.println(arrayList);

        int n = arrayList.size();
        int left = 0;
        int right = n - 1;

        ListNode trail = head;

        while(left <= right){
            trail.val = arrayList.get(left);
            trail = trail.next;
            left++;

            if(left <= right){
                trail.val = arrayList.get(right);
                trail = trail.next;
                right--;
            }
        }

    }

    public void convertToList(ListNode head, List<Integer> arrayList){

        while(head != null){
            arrayList.add(head.val);
            head = head.next;
        }

    }
}
