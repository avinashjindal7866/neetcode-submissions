class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        int alpha = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    int val =  dfs(grid,i,j);
                    alpha = Math.max(alpha,val); 
                }
            }
        }
        return alpha;
    }

    private int dfs(int[][] grid, int row, int col) {
    
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length ||
            grid[row][col] == 0) {
            return 0;
        }

        int[][] directions = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };  

        int count = 1;
        
        grid[row][col] = 0;  // Mark visited

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            count += dfs(grid, newRow, newCol);
        }
        
        return count;
        
    }
}
