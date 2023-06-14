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
        // Initialize the previous node as null, since it will be the last node in the reversed list
        ListNode prev = null;
        
        // Initialize the current node as the head of the input list
        ListNode cur = head;
        
        // Initialize the next node as the head of the input list
        ListNode next = head;
        
        // Iterate through the list until the current node becomes null (end of the list)
        while (cur != null) {
            // Store the next node of the current node before modifying the next pointer
            next = cur.next;
            
            // Reverse the next pointer of the current node to point to the previous node
            cur.next = prev;
            
            // Move the prev pointer to the current node
            prev = cur;
            
            // Move the current node to the next node
            cur = next;
        }
        
        // At the end of the iteration, the prev pointer will be pointing to the new head of the reversed list
        return prev;
    }
}
