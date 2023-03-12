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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        ListNode l1=lists[0];
        for(int i=1;i<lists.length;i++){
            if(lists[i]==null) continue;
            l1=solve(l1,lists[i]);
        }
        return l1;
    }
    private ListNode solve(ListNode h1,ListNode h2){
        ListNode dummy=new ListNode(-1); ListNode head=dummy;
        while(h1!=null&&h2!=null){
            if(h1.val<h2.val){
               dummy.next=h1;
                dummy=dummy.next;
                h1=h1.next;
            }
            else{
                dummy.next=h2;
                dummy=dummy.next;
                h2=h2.next;
            }
        }
        while(h1!=null){
            dummy.next=h1;
            dummy=dummy.next;
            h1=h1.next;
        }
        while(h2!=null){
            dummy.next=h2;
            dummy=dummy.next;
            h2=h2.next;
        }
        return head.next;
    }
}