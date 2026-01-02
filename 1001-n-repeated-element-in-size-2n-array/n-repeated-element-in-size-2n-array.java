class Solution {
    public int repeatedNTimes(int[] nums) {
        int max=0;
        for(int n:nums) max=Math.max(max,n);
        int[] dp=new int[max+1];
        for(int n:nums) dp[n]++;
        for(int n:nums) if(dp[n]==nums.length/2) return n;
        return 0;
    }
}