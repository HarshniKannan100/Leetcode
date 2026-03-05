class Solution {
    public int minDistance(String word1, String word2) {
        int w1=word1.length(),w2=word2.length();
        int[][] dp=new int[w1+1][w2+1];
        for(int i=0;i<=w2;i++){
            dp[w1][i]=w2-i;
        }
        for(int i=0;i<=w1;i++){
            dp[i][w2]=w1-i;
        }
        for(int i=w1-1;i>=0;i--){
            for(int j=w2-1;j>=0;j--){
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i][j]=dp[i+1][j+1];
                }else{
                    dp[i][j]=Math.min(dp[i+1][j],Math.min(dp[i][j+1],dp[i+1][j+1]))+1;
                }
            }
        }
        return dp[0][0];
    }
}
