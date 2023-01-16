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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy =new ListNode(-1);
        dummy.next=head; HashMap<Integer,ListNode>hs=new HashMap<>(); int sum=0;
        hs.put(0,dummy);
        while(head!=null){
            sum+=head.val;
            if(hs.containsKey(sum)){
                ListNode prev=hs.get(sum);
                ListNode curr=hs.get(sum).next;
                int currSum=sum;
                while(curr!=head){
                    currSum+=curr.val;
                    if(currSum!=0)
                   hs.remove(currSum);
                    curr=curr.next;
                }
                prev.next=head.next;
                
            }
            else
                hs.put(sum,head);
            head=head.next;
        }
        return dummy.next;
    }
}