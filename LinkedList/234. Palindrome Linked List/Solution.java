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
    // Method to reverse a singly-linked list
    private ListNode reverseLL(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = head;
        
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // Move 'slow' to the middle of the list and 'fast' to the end of the list
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second half of the list starting from 'slow.next'
        ListNode reversed = reverseLL(slow.next);
        
        // Connect the reversed second half back to the first half
        slow.next = reversed;
        
        ListNode p1 = head;  // Pointer for the first half of the list
        ListNode p2 = slow.next;  // Pointer for the second half of the list
        
        // Check if the list is a palindrome by comparing values from both halves
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;  // Values are different, not a palindrome
            }
            
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return true;  // All values matched, it is a palindrome
    }
}
