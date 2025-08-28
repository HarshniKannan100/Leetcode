class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int r=grid.length,c=grid[0].length;
        for(int i=r-1;i>=0;i--){
            int k=i;
            int j=0;
            Queue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
            while(k<r && j<c){
                pq.add(grid[k][j]);
                k++;
                j++;
            }
            k=i;
            j=0;
            while(k<r && j<c){
                grid[k][j]=pq.poll();
                k++;
                j++;
            }
        }

        for(int i=1;i<c;i++){
            int k=0;
            int j=i;
            Queue<Integer> pq=new PriorityQueue<>();
            while(k<r && j<c){
                pq.add(grid[k][j]);
                k++;
                j++;
            }
            k=0;
            j=i;
            while(k<r && j<c){
                grid[k][j]=pq.poll();
                k++;
                j++;
            }
        }
        return grid;
    }
}