class Solution {
    int alpha = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    dfs(grid,i,j,0);
                }
            }
        }
        return alpha;
    }

    private void dfs(int[][] grid, int row, int col,int count) {
    
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length ||
            grid[row][col] == 0) {
            return;
        }

        int[][] directions = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };
        
        grid[row][col] = 0;  // Mark visited
        count++;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            dfs(grid, newRow, newCol,count);
        }
        alpha = Math.max(alpha,count); 
    }
}
