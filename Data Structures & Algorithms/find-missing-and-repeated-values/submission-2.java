class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Map<Integer, Integer> mapList = new HashMap<>();
        int n = grid.length;
        int[] result = new int[2];
        for(int i=1;i<=n*n;i++){
                mapList.put(i, 0);
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                mapList.put(grid[i][j], mapList.getOrDefault(grid[i][j], 0) + 1);
            }
        }

        for(int i=1;i<=n*n;i++){
            // System.out.println(mapList.get(i) + " " + i);
            if(mapList.get(i) >= 2){
                result[0] = i;
            }else if(mapList.get(i) == 0){
                result[1] = i;
            }
        }

        return result;

    }
}