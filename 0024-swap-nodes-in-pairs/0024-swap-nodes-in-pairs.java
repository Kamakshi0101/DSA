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
    public void swap(ListNode prev,ListNode curr)
    {
        if(curr==null || curr.next==null) return;

        ListNode first=curr;
        ListNode second= curr.next;

        first.next=second.next;
        second.next=first;
        prev.next=second;

        swap(first,first.next);
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummy= new ListNode(-1);
        dummy.next=head;
        ListNode p=dummy;
        swap(p,head);
        return dummy.next;
    }
}