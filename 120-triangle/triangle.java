class Solution {
    public int minimumTotal(List<List<Integer>> list) {
        int n=list.size();
        int[][] dp=new int[n][n];
        dp[0][0]=list.get(0).get(0);
        for(int i=1;i<n;i++){
            dp[i][0]=dp[i-1][0]+list.get(i).get(0);
        }
        for(int i=1;i<n;i++){
            dp[i][i]=dp[i-1][i-1]+list.get(i).get(i);
        }
        for(int i=2;i<n;i++){
            for(int j=1;j<list.get(i).size()-1;j++){
                dp[i][j]=list.get(i).get(j)+Math.min(dp[i-1][j-1],dp[i-1][j]);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,dp[n-1][i]);
        }
        return min;
    }
}