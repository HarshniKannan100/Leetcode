class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        Queue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        boolean[][] vis=new boolean[n][n];
        pq.add(new int[]{0,0,grid[0][0]});
        vis[0][0]=true;
        int[][] diff={{-1,0},{1,0},{0,-1},{0,1}};
        int max=0;
        while(!pq.isEmpty()){
            int cell[]=pq.poll();
            max=Math.max(max,cell[2]);
            if(cell[0]==n-1 && cell[1]==n-1) break;
        for(int i=0;i<4;i++){
            int adjr=cell[0]+diff[i][0];
            int adjc=cell[1]+diff[i][1];
            if(adjr>=0 && adjr<n && adjc>=0 && adjc<n && !vis[adjr][adjc]){
                pq.add(new int[]{adjr,adjc,grid[adjr][adjc]});
                vis[adjr][adjc]=true;
            }
        }
        }
        return max;
    }
}