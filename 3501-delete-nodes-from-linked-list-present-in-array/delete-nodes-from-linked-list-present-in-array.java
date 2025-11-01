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
        Set<Integer> list=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        
        while(list.contains(head.val) && head.next!=null){
            head=head.next;
        }
        ListNode ans=head;
        while(head.next!=null && head.next.next!=null){
            if(list.contains(head.next.val)){
                head.next=head.next.next;
            }
            else head=head.next;
        }
        if(head.next!=null && list.contains(head.next.val)) head.next=null;
        return ans;
    }
}