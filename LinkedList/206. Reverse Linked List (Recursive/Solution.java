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
    public ListNode reverseList(ListNode head) {
        // If the list is empty or contains only one element, return the head
        if (head == null || head.next == null)
            return head;
        
        // Reverse the remaining part of the list
        ListNode reversedList = reverseList(head.next);
        
        // Adjust the pointers to reverse the current node
        head.next.next = head;
        head.next = null;
        
        // Return the new head of the reversed list
        return reversedList;
    }
}
