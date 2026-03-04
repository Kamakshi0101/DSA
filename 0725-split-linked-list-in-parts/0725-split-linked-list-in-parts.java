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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len=0;
        ListNode curr=head;
        while(curr!=null)
        {
            len++;
            curr=curr.next;
        }
        int uniform= len/k;
        int rem= len%k;

        ListNode[] res= new ListNode[k];
        curr=head;
        for(int i=0;i<k;i++)
        {
            int count= uniform;
            if(rem>0)
            {
                count++;
                rem--;
            }
            ListNode t1=curr,prev=null;
            int counter=0;
            while(counter<count)
            {
                prev=curr;
                curr=curr.next;
                counter++;
            }
            if(prev!=null) prev.next=null;

            res[i]=t1;
        }
        return res;
    }
}