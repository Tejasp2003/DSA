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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // Store the head of the even-indexed list
        
        while (even != null && even.next != null) {
            odd.next = even.next; // Connect odd-indexed node to the next odd-indexed node
            odd = odd.next; // Move odd pointer
            
            even.next = odd.next; // Connect even-indexed node to the next even-indexed node
            even = even.next; // Move even pointer
        }
        
        odd.next = evenHead; // Connect the end of odd-indexed list to the head of even-indexed list
        
        return head;
    }
}
