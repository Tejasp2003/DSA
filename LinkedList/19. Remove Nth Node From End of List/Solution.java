class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size=0;
        ListNode temp = head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        if(size==1)
            return null;
        if(size==n)// if the node to be deleted is the head node
            return head.next;
        System.out.println(size);

        temp = head;
        for(int i=0; i<size-n; i++)
            temp=temp.next;
        System.out.println(temp.val);
        temp.next=temp.next.next;
        return head;
    }
}