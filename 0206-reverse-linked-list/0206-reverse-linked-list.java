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
    public ListNode reverse(ListNode prev, ListNode curr)
    {
        if(curr==null) return prev;

        ListNode next= curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;

        return reverse(prev,curr);
    }
    public ListNode reverseList(ListNode head) {
        // ListNode curr=head;
        // ListNode prev=null;
        // while(curr!=null)
        // {
        //     ListNode temp=curr.next;
        //     curr.next=prev;
        //     prev=curr;
        //     curr=temp;
        // }
        // head=prev;
        // return head;

        return reverse(null,head);
    }
}