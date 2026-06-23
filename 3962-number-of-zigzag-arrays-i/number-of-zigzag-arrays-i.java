class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int d=r-l+1;
        int MOD=1000000007;
        int[][] dp=new int[n][d];
        Arrays.fill(dp[0],1);
        boolean flag=true;
        for(int i=1;i<n;i++){
            if(flag){
                for(int j=1;j<d;j++){
                    dp[i][j]=(dp[i][j-1]+dp[i-1][j-1])%MOD;
                }
                flag=false;
            }else{
                for(int j=d-2;j>=0;j--){
                    dp[i][j]=(dp[i][j+1]+dp[i-1][j+1])%MOD;
                }
                flag=true;
            }
        }

        int sum=0;
        for(int i=0;i<d;i++){
            sum=(sum+dp[n-1][i])%MOD;
        }
        return (sum*2)%MOD;
    }
}