class Solution {
    public boolean findSafeWalk(List<List<Integer>> list, int health) {
        Queue<int[]> q=new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        int R=list.size(),C=list.get(0).size();
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        int[][] grid=new int[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                grid[i][j]=list.get(i).get(j);
            }
        }
        int[][] dp=new int[R][C];
        q.add(new int[]{health,0,0});
        while(!q.isEmpty()){
            int[] poll=q.poll();
            int i=poll[1];
            int j=poll[2];
            int v=poll[0];
            if(grid[i][j]==1) v--;
            if(v==0) continue;
            if(i==R-1 && j==C-1) return true;
            if(dp[i][j]>=v) continue;
            dp[i][j]=v;
            for(int[] d:dir){
                int ai=i+d[0];
                int aj=j+d[1];
                if(ai>=0 && aj>=0 && ai<R && aj<C){
                    q.add(new int[]{v,ai,aj});
                }
            }
        }
        return false;
    }
}