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
    public ListNode swapNodes(ListNode head, int k) {
        int counter=0;
        ListNode n1=head;
        while(counter<k-1)
        {
            counter++;
            n1=n1.next;
        }
        ListNode t1=n1;
        ListNode n2=head;
        while(t1.next!=null)
        {
            t1=t1.next;
            n2=n2.next;
        }
        int temp= n1.val;
        n1.val=n2.val;
        n2.val=temp;
        return head;
    }
}