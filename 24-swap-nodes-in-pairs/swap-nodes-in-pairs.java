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
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        ListNode temp=new ListNode(0,head);
        ListNode prev=temp;
        while(prev.next!=null && prev.next.next!=null){
            ListNode f=prev.next;
            ListNode s=prev.next.next;
            f.next=s.next;
            s.next=f;
            prev.next=s;
            prev=f;
        }
        return temp.next;
    }
}