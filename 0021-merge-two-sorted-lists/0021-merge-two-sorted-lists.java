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
    public void merge(ListNode list1,ListNode list2,ListNode curr)
    {
        if(list1==null)
        {
            curr.next=list2;
            return;
        }
        if(list2==null)
        {
            curr.next=list1;
            return;
        }
        if(list1.val<list2.val)
        {
            curr.next=list1;
            merge(list1.next,list2,curr.next);
        }
        else
        {
            curr.next=list2;
            merge(list1,list2.next,curr.next);
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        // while(l1!=null && l2!=null)
        // {
        //     if(l1.val<l2.val)
        //     {
        //         curr.next=l1;
        //         l1=l1.next;
        //     }
        //     else
        //     {
        //         curr.next=l2;
        //         l2=l2.next;
        //     }
        //     curr=curr.next;
        // }
        // curr.next=(l1!=null)?l1:l2;
        merge(l1,l2,curr);
        return dummy.next;
    }
}