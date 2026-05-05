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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode p=head,s=p;
        int len=1;
        if(head==null || head.next==null|| k==0 ) return head;
        while(p.next!=null){
            p=p.next;
            len++;
        }
        k=k%len;
        p.next=head;
        len=len-k;
        for(int i=0;i<len-1;i++){
            s=s.next;
        }
        head=s.next;
        s.next=null;
        return head;
    }
}