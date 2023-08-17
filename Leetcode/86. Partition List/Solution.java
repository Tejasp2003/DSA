class Solution {
    public ListNode partition(ListNode temp, int x) {
        ListNode right = new ListNode();
        ListNode left = new ListNode();
        ListNode l = left;
        ListNode r = right;
        
        while(temp!=null){
            if(temp.val <x){
                l.next= temp;
                l=l.next;
                
            }
            else{
                r.next = temp;
                r=r.next;
                
            }
            temp = temp.next;
        }
        l.next=right.next;
        r.next=null;
        return left.next;
        
        
    }
}