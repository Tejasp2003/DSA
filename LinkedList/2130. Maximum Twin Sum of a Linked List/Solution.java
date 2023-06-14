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
    private ListNode ReverseLL(ListNode head){
     ListNode cur=head;
     ListNode prev=null;
     ListNode next=head;
     while(cur!=null){
         next=cur.next;
         cur.next=prev;
         prev=cur;
         cur=next;
     }
     return prev;
 }
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode temp= ReverseLL(slow.next);
        slow.next=temp;
        int sum=0;
        ListNode p1=head;
        ListNode p2=slow.next;
        while(p2!=null){
            sum=Math.max(sum, p1.val+p2.val);
            p1=p1.next;
            p2=p2.next;
        }
        return sum;
    }
}