class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int cur=x+k-1;
        for(int i=x;i<x+(k/2);i++){
            for(int j=y;j<(y+k);j++){
                int t=grid[i][j];
                grid[i][j]=grid[cur][j];
                grid[cur][j]=t;
            }
            cur--;
        }
        return grid;
    }
}