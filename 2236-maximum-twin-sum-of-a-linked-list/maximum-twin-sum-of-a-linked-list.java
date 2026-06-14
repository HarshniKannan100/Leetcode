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
    public int pairSum(ListNode head) {
        int n=0;
        ListNode temp=head;
        while(temp.next!=null){
            n++;
            temp=temp.next;
        }
        n++;
        int[] arr=new int[n/2];
        temp=head;
        for(int i=0;i<n/2;i++){
            arr[i]=temp.val;
            temp=temp.next;
        }
        int max=0;
        for(int i=n/2;i<n;i++){
            arr[n-1-i]+=temp.val;
            max=Math.max(max,arr[n-1-i]);
            temp=temp.next;
        }
        return max;
    }
}