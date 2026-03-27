class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int R=mat.length,C=mat[0].length;
        int res[][]=new int[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                res[i][(j+k)%C]=mat[i][j];
            }
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(mat[i][j]!=res[i][j]) return false;
            }
        }
        return true;
    }
}