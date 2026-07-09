class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] dp=new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]<=maxDiff){
                dp[i]=dp[i-1];
            }else{
                dp[i]=dp[i-1]+1;
            }
        }
        boolean[] ans=new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            int u=queries[i][0];
            int v=queries[i][1];
            ans[i]=(dp[u]==dp[v]);
        }
        return ans;
    }
}