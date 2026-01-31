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
    public void reorderList(ListNode head) {
        ListNode p=head;
        Stack<ListNode> st=new Stack<>();
        while(p!=null){
            st.push(p);
            p=p.next;
        }
        ListNode t=head;
        int n=(st.size()/2);
        while(n-->0){
            ListNode pop=st.pop();
            ListNode temp=t.next;
            t.next=pop; 
            pop.next=temp; 
            t=temp;      
        }
        t.next=null;
    }
}
