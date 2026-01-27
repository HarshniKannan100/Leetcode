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
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode prev=head;
        ListNode start=head;
        if(head.next!=null) head=head.next;
        while(head.next!=null){
            ListNode cur=head;
            head=head.next;
            cur.next=prev;
            prev=cur;
        }
        head.next=prev;
        start.next=null;
        return head;
    }
}
