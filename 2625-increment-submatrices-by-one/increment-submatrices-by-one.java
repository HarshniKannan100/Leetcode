class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat=new int[n][n];
        for(int[] q:queries){
            for(int row=q[0];row<=q[2];row++){
                for(int col=q[1];col<=q[3];col++){
                    mat[row][col]++;
                }
            }
        }
        return mat;
    }
}