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
        ListNode prev=temp,cur=head;
        boolean flag=false;
        while(cur.next!=null){
            prev.next=cur.next;
            ListNode t=cur.next.next;
            cur.next.next=cur;
            prev=cur;
            if(t==null){
                cur.next=t;
                flag=true;
                break;
            }else{
                cur=t;
            }
        }
        if(!flag && cur.next==null) prev.next=cur;
        return temp.next;
    }
}