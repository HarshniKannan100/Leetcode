class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int R = grid1.length, C = grid1[0].length;
        int count = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(grid2[i][j] == 1) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    grid2[i][j] = 0;
                    boolean isSubIsland = true;
                    while(!q.isEmpty()) {
                        int[] cur = q.poll();
                        int r = cur[0], c = cur[1];
                        if(grid1[r][c] == 0) {
                            isSubIsland = false;
                        }
                        for(int[] d : dir) {
                            int nr = r + d[0];
                            int nc = c + d[1];
                            if(nr >= 0 && nc >= 0 && nr < R && nc < C 
                               && grid2[nr][nc] == 1) {
                                q.add(new int[]{nr, nc});
                                grid2[nr][nc] = 0;
                            }
                        }
                    }
                    if(isSubIsland) count++;
                }
            }
        }
        return count;
    }
}