class Solution {
    public int maxProductPath(int[][] grid) {
        int r=grid.length,c=grid[0].length;
        long[][] max=new long[r][c];
        long[][] min=new long[r][c];
        max[0][0]=grid[0][0];
        min[0][0]=grid[0][0];
        for(int i=1;i<c;i++){
            max[0][i]=max[0][i-1]*grid[0][i];
            min[0][i]=min[0][i-1]*grid[0][i];
        }
        for(int i=1;i<r;i++){
            max[i][0]=max[i-1][0]*grid[i][0];
            min[i][0]=min[i-1][0]*grid[i][0];
        }
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                long max1=Math.max(max[i-1][j]*grid[i][j],max[i][j-1]*grid[i][j]);
                long max2=Math.max(min[i-1][j]*grid[i][j],min[i][j-1]*grid[i][j]);
                long min1=Math.min(max[i-1][j]*grid[i][j],max[i][j-1]*grid[i][j]);
                long min2=Math.min(min[i-1][j]*grid[i][j],min[i][j-1]*grid[i][j]);
                max[i][j]=Math.max(max1,max2);
                min[i][j]=Math.min(min1,min2);
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(max[i][j]+" ");
            }
            System.out.println();
        }
        return max[r-1][c-1]<0?-1:(int)(max[r-1][c-1]%1000000007);
    }
}