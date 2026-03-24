class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int r=grid.length,c=grid[0].length;
        long[] pre=new long[r*c];
        long[] suf=new long[r*c];
        int idx=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i==0 && j==0) pre[idx]=grid[i][j];
                else{
                    pre[idx]=(grid[i][j]*pre[idx-1])%12345;
                }
                idx++;
            }
        }
        idx=r*c-1;
        for(int i=r-1;i>=0;i--){
            for(int j=c-1;j>=0;j--){
                if(i==r-1 && j==c-1){
                    suf[idx]=grid[i][j];
                }else{
                    suf[idx]=(grid[i][j]*suf[idx+1])%12345;
                }
                idx--;
            }
        }
        idx=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i==0 && j==0) grid[i][j]=(int)(suf[1]%12345);
                else if(i==r-1 && j==c-1) grid[i][j]=(int)(pre[r*c-2]%12345);
                else{
                    grid[i][j]=(int)((pre[idx-1]*suf[idx+1])%12345);
                }
                idx++;
            }
        }
        return grid;
    }
}