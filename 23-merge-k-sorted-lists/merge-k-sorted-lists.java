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
    ListNode mergeList(ListNode l1,ListNode l2){
        ListNode head=new ListNode();
        ListNode p=head;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                p.next=l1;
                l1=l1.next;
            }else{
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }
        if(l1!=null){
            p.next=l1;
        }else p.next=l2;

        return head.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }
        while(lists.length>1){
            List<ListNode> mergedLists=new ArrayList<>();
            for(int i=0;i<lists.length;i+=2){
                ListNode l1=lists[i];
                ListNode l2=(i+1<lists.length)?lists[i+1]:null;
                mergedLists.add(mergeList(l1,l2));
            }
            lists=mergedLists.toArray(new ListNode[0]);
        }
        return lists[0];
    }
}