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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode l=new ListNode(0);
        l.next=head;
        ListNode start=l;
        while(true){
            ListNode check=start;
            for(int i=0;i<k;i++){
                check=check.next;
                if(check==null){
                    return l.next;
                }
            }
            ListNode p1=start.next,p2=p1.next;
            for(int i=0;i<k-1;i++){
                ListNode temp=p2.next;
                p2.next=p1;
                p1=p2;
                p2=temp;
            }
            ListNode tail=start.next;
            tail.next=p2;
            start.next=p1;
            start=tail;
        }
    }
}
