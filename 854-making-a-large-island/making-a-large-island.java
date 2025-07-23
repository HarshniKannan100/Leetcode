class Solution {
    private void dfs(int[][] grid, int row, int col, int ictr,boolean visited[][]){
        grid[row][col]=ictr;
        visited[row][col]=true;
        int[][] diff={{0,1},{0,-1},{1,0},{-1,0}};
        for(int c=0;c<4;c++){
            int adjr=row+diff[c][0];
            int adjc=col+diff[c][1];
            if(adjr>=0 && adjr<grid.length && adjc>=0 && adjc<grid[0].length){
                if(grid[adjr][adjc]==1 && !visited[adjr][adjc]){
                    dfs(grid,adjr,adjc,ictr,visited);
                }
            }
        }
    }


    public int largestIsland(int[][] grid) {
        int ictr=1;
        int maxLen=0;
        int n=grid.length,m=grid[0].length;
        boolean visited[][]=new boolean[n][m];
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                    if(grid[row][col]==1 && !visited[row][col]){
                        dfs(grid,row,col,ictr++,visited);

                    }
            }
        }
        int[] count=new int[ictr+1];
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                count[grid[row][col]]++;
            }
        }
        
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(grid[row][col]!=0) continue;
                    Set<Integer> set=new HashSet<>();
                    int[][] diff={{0,1},{0,-1},{1,0},{-1,0}};
                    for(int i=0;i<4;i++){
                        int adjr=row+diff[i][0];
                        int adjc=col+diff[i][1];
                        if(adjr>=0 && adjr<n && adjc>=0 && adjc<m && grid[adjr][adjc]!=0){
                            set.add(grid[adjr][adjc]);
                        }
                    }
                    int len=1;
                    for(int i:set){
                        len+=count[i];
                    }
                    maxLen=Math.max(len,maxLen);

                
            }
        }
        if(maxLen==0){
            for(int i:count){
                maxLen=Math.max(i,maxLen);
            }
        }
        return maxLen;
    }

}