class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int R=grid.length,C=grid[0].length;
        int[][][] dp=new int[R][C][k+1];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        dp[0][0][0]=0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                for(int c=0;c<=k;c++){
                    if(dp[i][j][c]==-1) continue;
                    if(i+1<R){
                        int cost=(grid[i+1][j]==0?0:1);
                        if(cost+c<=k){
                            dp[i+1][j][cost+c]=Math.max(dp[i+1][j][cost+c],dp[i][j][c]+grid[i+1][j]);
                        }
                    }
                    if(j+1<C){
                        int cost=(grid[i][j+1]==0?0:1);
                        if(cost+c<=k){
                            dp[i][j+1][cost+c]=Math.max(dp[i][j+1][cost+c],dp[i][j][c]+grid[i][j+1]);
                        }
                    }
                }
            }
        }
        int max=-1;
        for(int i=0;i<=k;i++){
            max=Math.max(max,dp[R-1][C-1][i]);
        }
        return max;
    }
}