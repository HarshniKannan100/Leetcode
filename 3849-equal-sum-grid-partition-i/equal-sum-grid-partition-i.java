class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int R=grid.length,C=grid[0].length;
        long[] rowPre=new long[R];
        long[] rowSuf=new long[R];
        long[] colPre=new long[C];
        long[] colSuf=new long[C];
        long prev=0;
        for(int i=0;i<R;i++){
            long sum=0;
            for(int j=0;j<C;j++){
                sum+=grid[i][j];
            }
            rowPre[i]=sum+prev;
            prev=rowPre[i];
        }
        prev=0;
        for(int i=R-1;i>=0;i--){
            long sum=0;
            for(int j=0;j<C;j++){
                sum+=grid[i][j];
            }
            rowSuf[i]=sum+prev;
            prev=rowSuf[i];
        }
        prev=0;
        for(int j=0;j<C;j++){
            long sum=0;
            for(int i=0;i<R;i++){
                sum+=grid[i][j];
            }
            colPre[j]=sum+prev;
            prev=colPre[j];
        }
        prev=0;
        for(int j=C-1;j>=0;j--){
            long sum=0;
            for(int i=0;i<R;i++){
                sum+=grid[i][j];
            }
            colSuf[j]=sum+prev;
            prev=colSuf[j];
        }
        for(int i=0;i<R-1;i++){
            if(rowPre[i]==rowSuf[i+1]) return true;
        }
        for(int i=0;i<C-1;i++){
            if(colPre[i]==colSuf[i+1]) return true;
        }
        return false;
    }
}