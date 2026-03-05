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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy= new ListNode(0);
        dummy.next=head;
        ListNode curr=head;
        int len=0;
        while(curr!=null)
        {
            len++;
            curr=curr.next;
        }
        int times= len/k;
        curr=head;
        ListNode p1=dummy;
        for(int i=0;i<times;i++)
        {
            int count=0;
            ListNode prev=null;
            ListNode p2=curr;
            while(count<k)
            {
                count++;

                ListNode temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }
            p1.next=prev;
            p2.next=curr;
            p1=p2;
        }
        return dummy.next;
    }
}