class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int R=mat.length,C=mat[0].length;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(mat[i][(j+k)%C]!=mat[i][j]) return false;
            }
        }
        return true;
    }
}