class Solution {
    int MOD=1000000007;
    int dfs(int R, int C, int k,int r, int c,Integer[][][] dp,int[][] mat){
        if(mat[r][c]==0) return 0;
        if(k==0) return 1;
        if(dp[k][r][c]!=null) return dp[k][r][c];
        int ans=0;
        for(int row=r+1;row<R;row++){
            if(mat[r][c]-mat[row][c]>0){
                ans=(ans+dfs(R,C,k-1,row,c,dp,mat))%MOD;
            }
        }
        for(int col=c+1;col<C;col++){
            if(mat[r][c]-mat[r][col]>0){
                ans=(ans+dfs(R,C,k-1,r,col,dp,mat))%MOD;
            }
        }
        return dp[k][r][c]=ans;
    }
    public int ways(String[] pizza, int k) {
        int R=pizza.length,C=pizza[0].length();
        int[][] mat=new int[R+1][C+1];
        for(int r=R-1;r>=0;r--){
            for(int c=C-1;c>=0;c--){
                mat[r][c]=mat[r+1][c]+mat[r][c+1]-mat[r+1][c+1];
                if(pizza[r].charAt(c)=='A') mat[r][c]++;
            }
        }
        Integer[][][] dp=new Integer[k][R][C];
        return dfs(R,C,k-1,0,0,dp,mat);
    }
}