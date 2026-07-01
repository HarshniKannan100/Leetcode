class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int N=grid.size();
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        if(grid.get(0).get(0)==1 || grid.get(N-1).get(N-1)==1) return 0;
        int[][] mat=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                mat[i][j]=grid.get(i).get(j);
            }
        }
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(mat[i][j]==1) q.add(new int[]{i,j});
            }
        }
        while(q.size()>0){
            int[] poll=q.poll();
            int i=poll[0];
            int j=poll[1];
            int v=mat[i][j];
            for(int[] d:dir){
                int ai=i+d[0];
                int aj=j+d[1];
                if(ai>=0 && aj>=0 && ai<N && aj<N && mat[ai][aj]==0){
                    mat[ai][aj]=v+1;
                    q.add(new int[]{ai,aj});
                }
            }
        }

        Queue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        pq.add(new int[]{mat[0][0],0,0});
        while(pq.size()>0){
            int[] poll=pq.poll();
            int v=poll[0];
            int i=poll[1];
            int j=poll[2];
            if(i==N-1 && j==N-1) return v-1;
            for(int[] d:dir){
                int ai=i+d[0];
                int aj=j+d[1];
                if(ai>=0 && aj>=0 && ai<N && aj<N && mat[ai][aj]>0){
                    pq.add(new int[]{Math.min(v,mat[ai][aj]),ai,aj});
                    mat[ai][aj]*=-1;
                }
            }
        }
        return mat[N-1][N-1]-1;
    }
}