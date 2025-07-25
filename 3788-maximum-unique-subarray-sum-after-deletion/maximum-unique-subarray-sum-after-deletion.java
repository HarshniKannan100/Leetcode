class Solution {
    public int maxSum(int[] nums) {
        int[] unique=new int[201];
        int max=Integer.MIN_VALUE;
        for(int n:nums){
            unique[n+100]=n;
            max=Math.max(max,n);
        }
        if(max<0) return max;
        int sum=0;
        for(int n:unique){
            if(sum+n>sum) sum+=n;
        }
        return sum;
    }
}