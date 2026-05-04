class Solution {
    public void rotate(int[][] matrix) {
        int res[][]=new int[matrix[0].length][matrix.length]; 
        for(int i=0;i<matrix.length;i++){
            for(int j=0; j<matrix[0].length;j++){
                res[j][i]=matrix[i][j];
            }
        }
        int k=0;
        for(int[] mat:res){
            int j=0;
            for(int i=mat.length-1;i>=0;i--){
                matrix[k][j++]=mat[i];
            }k++;
        }
    
    }
}