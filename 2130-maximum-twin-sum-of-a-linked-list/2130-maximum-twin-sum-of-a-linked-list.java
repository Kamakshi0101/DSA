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
    public ListNode reverse(ListNode node)
    {
        ListNode prev=null;
        ListNode curr=node;
        while(curr!=null)
        {
            ListNode temp= curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        // List<Integer> list= new ArrayList<>();
        // while(head!=null)
        // {
        //     list.add(head.val);
        //     head=head.next;
        // }
        // int i=0,j=list.size()-1;
        // int max= Integer.MIN_VALUE;
        // while(i<j)
        // {
        //     int sum=list.get(i)+list.get(j);
        //     max= Math.max(max,sum);
        //     i++;
        //     j--;
        // }
        // return max;

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode p2= reverse(slow);
        ListNode p1=head;
        int max=0;
        while(p1!=null && p2!=null)
        {
            int sum= p1.val+p2.val;
            max= Math.max(max,sum);
            p1=p1.next;
            p2=p2.next;
        }
        return max;
    }
}