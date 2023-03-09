/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
         ListNode slow =head;ListNode fast=head;
        do{
            if(fast.next==null || fast.next.next==null)
                return null;
            else{
                slow = slow.next;
                fast=fast.next.next;
            }
        }
        while(slow!=fast);
        slow=head; 
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}