class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[][] dp=new int[numRows][numRows];
        List<List<Integer>> biglist=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            dp[i][0]=1;
            dp[i][i]=1;
        }
        for(int i=2;i<numRows;i++){
            for(int j=1;j<i;j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
        }
        for(int i=0;i<numRows;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<=i;j++){
                list.add(dp[i][j]);
            }
            biglist.add(list);
        }
        return biglist;
    }
}