
class Solution {

    int[][] directions = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        Set<String> pacific = new HashSet<>();
        Set<String> atlantic = new HashSet<>();

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        // Add Pacific border cells
        for (int r = 0; r < rows; r++) {
            addCell(r, 0, pacific, pacificQueue);
        }

        for (int c = 0; c < cols; c++) {
            addCell(0, c, pacific, pacificQueue);
        }

        // Add Atlantic border cells
        for (int r = 0; r < rows; r++) {
            addCell(r, cols - 1, atlantic, atlanticQueue);
        }

        for (int c = 0; c < cols; c++) {
            addCell(rows - 1, c, atlantic, atlanticQueue);
        }

        // Run BFS for both oceans
        bfs(heights, pacificQueue, pacific);
        bfs(heights, atlanticQueue, atlantic);

        // Find intersection
        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                String key = r + "," + c;

                if (pacific.contains(key) && atlantic.contains(key)) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void addCell(
        int r,
        int c,
        Set<String> visited,
        Queue<int[]> queue
    ) {
        String key = r + "," + c;

        if (visited.add(key)) {
            queue.offer(new int[]{r, c});
        }
    }

    private void bfs(
        int[][] heights,
        Queue<int[]> queue,
        Set<String> visited
    ) {

        int rows = heights.length;
        int cols = heights[0].length;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                // Boundary check
                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) {
                    continue;
                }

                String key = nr + "," + nc;

                // Already visited
                if (visited.contains(key)) {
                    continue;
                }

                // Reverse water-flow condition
                if (heights[nr][nc] >= heights[r][c]) {

                    visited.add(key);
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
