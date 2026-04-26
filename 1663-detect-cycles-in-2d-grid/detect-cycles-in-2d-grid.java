class Solution {
    static int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
    boolean dfs(int i,int j,int pi,int pj,int R,int C,char[][] grid,boolean[][] vis){
        vis[i][j]=true;
        for(int c=0;c<4;c++){
            int ar=i+dir[c][0];
            int ac=j+dir[c][1];
            if(ar>=0 && ar<R && ac>=0 && ac<C && grid[i][j]==grid[ar][ac] && (pi!=ar || pj!=ac)){
                if(vis[ar][ac]  || dfs(ar,ac,i,j,R,C,grid,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        int R=grid.length,C=grid[0].length;
        boolean[][] vis=new boolean[R][C];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!vis[i][j] && dfs(i,j,-1,-1,R,C,grid,vis)) return true;
            }
        }
        return false;
    }
}