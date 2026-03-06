class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                if(j==0){
                    int buy=dp[i+1][0]-prices[i];
                    int cdown=dp[i+1][1];
                    dp[i][1]=Math.max(buy,cdown);
                }else{
                    int sell=(i+2<n)?dp[i+2][1]+prices[i]:prices[i];
                    int cdown=dp[i+1][0];
                    dp[i][0]=Math.max(sell,cdown);
                }
            }
        }
        return dp[0][1];
    }
}
