class Solution {

    int[][] directions = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int orangesRotting(int[][] grid) {

        Queue<int[]> pq = new LinkedList<>();

        // Add ALL rotten oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 2) {
                    pq.add(new int[]{i, j});
                }
            }
        }

        return middleFun(grid, pq);
    }

    private int middleFun(int[][] grid, Queue<int[]> pq) {

        int timeTaken = 0;

        while (!pq.isEmpty()) {

            // Number of oranges at current minute
            int size = pq.size();

            for (int i = 0; i < size; i++) {

                int[] val = pq.poll();

                for (int[] dir : directions) {

                    int newRow = val[0] + dir[0];
                    int newCol = val[1] + dir[1];

                    if (dfs(grid, newRow, newCol)) {
                        pq.add(new int[]{newRow, newCol});
                    }
                }
            }

            // One complete BFS level = one minute
            if (!pq.isEmpty()) {
                timeTaken++;
            }
        }

        // Check if any fresh orange is remaining
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return timeTaken;
    }

    private boolean dfs(int[][] grid, int r, int c) {

        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length ||
            grid[r][c] != 1) {
            return false;
        }

        grid[r][c] = 2;

        return true;
    }
}