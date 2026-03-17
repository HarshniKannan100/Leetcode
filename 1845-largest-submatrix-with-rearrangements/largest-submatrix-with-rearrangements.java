class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int M=matrix.length,N=matrix[0].length;
        int max=0;
        for(int i=1;i<M;i++){
            for(int j=0;j<N;j++){
                if(matrix[i][j]==1){
                    matrix[i][j]+=matrix[i-1][j];
                }
            }
        }
        for(int i=0;i<M;i++){
            Arrays.sort(matrix[i]);
            for(int j=0;j<N;j++){
                max=Math.max(max,matrix[i][j]*(N-j));
            }
        }
        return max;
    }
}