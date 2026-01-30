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
import java.math.BigInteger;
class Solution {
    BigInteger revSum(ListNode l){
        BigInteger sum=BigInteger.ZERO;
        BigInteger m=BigInteger.ONE;
        while(l!=null){
            sum=sum.add(BigInteger.valueOf(l.val).multiply(m));
            m=m.multiply(BigInteger.TEN);
            l=l.next;
        }
        return sum;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger sum=BigInteger.ZERO;
        sum=revSum(l1).add(revSum(l2));

        int mod=sum.mod(BigInteger.TEN).intValue();
        ListNode l=new ListNode(mod);
        sum=sum.divide(BigInteger.TEN);
        ListNode head=l;
        while(sum.compareTo(BigInteger.ZERO)>0){
            mod=sum.mod(BigInteger.TEN).intValue();
            l.next=new ListNode(mod);
            sum=sum.divide(BigInteger.TEN);
            l=l.next;
        }
        return head;
    }
}
