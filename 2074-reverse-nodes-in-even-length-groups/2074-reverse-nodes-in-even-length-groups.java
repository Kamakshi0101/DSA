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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode curr=head;
        int len=0;
        while(curr!=null)
        {
            len++;
            curr=curr.next;
        }
        curr=head;
        int psize=1;
        ListNode p=null;
        while(curr!=null)
        {
            int asize=Math.min(psize,len);
            if(asize%2==0)
            {
                ListNode prev=null;
                ListNode temp1=curr;
                int count=0;
                while(count<asize)
                {
                    count++;
                    ListNode next=curr.next;
                    curr.next=prev;
                    prev=curr;
                    curr=next;
                }
                p.next=prev;
                temp1.next=curr;
                p=temp1;
            }
            else
            {
                int counter=0;
                while(counter<asize)
                {
                    counter++;
                    p=curr;
                    curr=curr.next;
                }
            }
            psize++;
            len=len-asize;
        }
        return head;
    }
}