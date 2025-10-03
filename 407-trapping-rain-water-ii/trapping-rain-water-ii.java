class Solution {
    public int trapRainWater(int[][] heightMap) {
         if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.height, b.height));
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int waterTrapped = 0;

        // Process the cells in the priority queue
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();

            for (int[] dir : directions) {
                int x = cell.row + dir[0];
                int y = cell.col + dir[1];

                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;

                    // Calculate water trapped at this cell
                    waterTrapped += Math.max(0, cell.height - heightMap[x][y]);

                    // Add the new cell to the queue with updated height
                    pq.offer(new Cell(x, y, Math.max(cell.height, heightMap[x][y])));
                }
            }
        }

        return waterTrapped;
    }
    static class Cell {
        int row;
        int col;
        int height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}