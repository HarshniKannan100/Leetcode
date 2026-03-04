class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1) return false;
        int tar=sum/2;
        boolean[] dp=new boolean[tar+1];
        dp[0]=true;
        for(int i=0;i<nums.length;i++){
            for(int j=tar;j>=nums[i];j--){
                dp[j]=dp[j] || dp[j-nums[i]];
            }
        }
        return dp[tar];
    }
}
