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
    public ListNode modifiedList(int[] nums, ListNode head) {
        int[] freq=new int[100001];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        
        while(freq[head.val]!=0 && head.next!=null){
            head=head.next;
        }
        ListNode ans=head;
        while(head.next!=null && head.next.next!=null){
            if(freq[head.next.val]!=0){
                head.next=head.next.next;
            }
            else head=head.next;
        }
        if(head.next!=null && freq[head.next.val]!=0) head.next=null;
        return ans;
    }
}