class Solution {
    private int fetchArrIndex(int row,int col, int C){
        return col+row*C+1;
    }

    private void join(int left,int right,int[] leader){
        leader[find(right,leader)]=find(left,leader);
    }

    private int find(int node,int[] leader){
        if(node==leader[node]) return node;
        leader[node]=find(leader[node],leader);
        return leader[node];
    }

    public int latestDayToCross(int R, int C, int[][] cells) {
        int[] leader=new int[R*C+2];
        int days=0;
        for(int i=0;i<R*C+2;i++){
            leader[i]=i;
        }
        int diff[][]={{-1,-1},{-1,0},{1,0},{1,1},{0,-1},{0,1},{1,-1},{-1,1}};
        boolean[][] water=new boolean[R][C];
        for(int cell[] :cells){
            int row=cell[0]-1;
            int col=cell[1]-1;
            water[row][col]=true;
            for(int i=0;i<8;i++){
                int adjr=row+diff[i][0];
                int adjc=col+diff[i][1];
                if(adjr>=0 && adjr<R && adjc>=0 && adjc<C && water[adjr][adjc]){
                    join(fetchArrIndex(adjr,adjc,C),fetchArrIndex(row,col,C),leader);
                }
            }
        if(col==0)
            join(0,fetchArrIndex(row,col,C),leader);
        if(col==C-1)
            join(fetchArrIndex(row,col,C),R*C+1,leader);
        if(find(0, leader) == find(R*C + 1, leader))
            return days;
        days++;
        }
        return -1;
    }
}