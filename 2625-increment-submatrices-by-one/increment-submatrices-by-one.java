class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat=new int[n][n];
        for(int[] q:queries){
            for(int row=q[0];row<=q[2];row++){
                mat[row][q[1]]++;
                if(q[3]+1<n) mat[row][q[3]+1]--;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                mat[i][j]+=mat[i][j-1];
            }
        }
        return mat;
    }
}