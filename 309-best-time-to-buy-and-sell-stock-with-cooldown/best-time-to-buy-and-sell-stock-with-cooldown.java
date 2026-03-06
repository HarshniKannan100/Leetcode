class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        for(int i=n-1;i>=0;i--){
            int buy=dp[i+1][0]-prices[i];
            int cdown=dp[i+1][1];
            dp[i][1]=Math.max(buy,cdown);
            int sell=(i+2<n)?dp[i+2][1]+prices[i]:prices[i];
            cdown=dp[i+1][0];
            dp[i][0]=Math.max(sell,cdown);
        }
        return dp[0][1];
    }
}
