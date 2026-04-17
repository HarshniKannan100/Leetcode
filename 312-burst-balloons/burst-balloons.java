class Solution {
    int burst(int[] nums,int l,int r,int N,Integer[][] dp){
        if(l>r) return 0;
        if(dp[l][r]!=null) return dp[l][r];
        int max=0;
        for(int i=l;i<=r;i++){
            int cur=burst(nums,l,i-1,N,dp)+burst(nums,i+1,r,N,dp);
            int thislast=nums[i]*(l-1>=0?nums[l-1]:1)*(r+1<N?nums[r+1]:1);
            cur+=thislast;
            max=Math.max(max,cur);
        }
        dp[l][r]=max;
        return max;
    }
    public int maxCoins(int[] nums) {
        int N=nums.length;
        Integer[][] dp=new Integer[N][N];
        return burst(nums,0,N-1,N,dp);
    }
}