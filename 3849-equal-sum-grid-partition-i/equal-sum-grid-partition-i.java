class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long tot=0;
        int R=grid.length,C=grid[0].length;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                tot+=grid[i][j];
            }
        }
        if(tot%2!=0) return false;
        long sum=0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                sum+=grid[i][j];
            }
            if(tot/2==sum) return true;
        }
        sum=0;
        for(int j=0;j<C;j++){
            for(int i=0;i<R;i++){
                sum+=grid[i][j];
            }
            if(tot/2==sum) return true;
        }
        return false;
    }
}