class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] storeUsedCell = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    storeUsedCell[i][j] = true;
                    boolean val = searchWord(board,i,j,storeUsedCell,1,word);
                    if(val){
                        return true;
                    }
                    storeUsedCell[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean searchWord(char[][] board,int row,int column,boolean[][] usedCell,int charIndex,String word){
        if(row >= board.length || column >= board[0].length){
            return false;
        }

        if(charIndex >= word.length()){
            return true;
        }

        int[][] leftRight = new int[][] {
    {-1, 0}, {1, 0}, {0, -1}, {0, 1}
};
        
        for(int i=0;i<leftRight.length;i++){
            int newRow = row + leftRight[i][0];
            int newCol = column + leftRight[i][1];
            if(newRow < board.length && newRow >= 0 && newCol < board[0].length && newCol >= 0 ){
                
                if(board[newRow][newCol] == word.charAt(charIndex) && usedCell[newRow][newCol] == false){
                    System.out.println(board[newRow][newCol]);
                   usedCell[newRow][newCol] = true;
                boolean val = searchWord(board,newRow,newCol,usedCell,charIndex+1,word);
                if(val){
                    return true;
                }
                   usedCell[newRow][newCol] = false;
                }
            }
        }

        return false;
    }
}
