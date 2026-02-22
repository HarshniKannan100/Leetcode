class Solution {
    private void dfs(int m,int n,char[][] grid,int i,int j){
        int diff[][]=new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        grid[i][j]='0';
        for(int ctr=0;ctr<4;ctr++){
            int adjr=i+diff[ctr][0];
            int adjc=j+diff[ctr][1];
            if(adjr>=0 && adjr<m && adjc>=0 && adjc<n){
                if(grid[adjr][adjc]=='1'){
                    dfs(m,n,grid,adjr,adjc);
                }
            }
        }
    } 
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length,count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(m,n,grid,i,j);
                }
            }
        }return count;
    }
        
}