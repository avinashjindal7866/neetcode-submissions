class Solution {

    class Node{
        char ch;
        boolean isTerminal;
        HashMap<Character,Node> child;

        Node(char ch,boolean isTerminal, HashMap<Character, Node> child) {
            this.ch = ch;
            this.isTerminal = isTerminal;
            this.child = child;
        }
    }


    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node('*',false, new HashMap<>());

        for(String s : words){
            addWord(s,root);
        }

        boolean[][] storeUsedCell = new boolean[board.length][board[0].length];
        List<String> result = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(root.child.containsKey(board[i][j])){
                    List<Character> charList = new ArrayList<>();
                    charList.add(board[i][j]);
                    storeUsedCell[i][j] = true;
                    searchWord(board,i,j,root.child.get(board[i][j]),storeUsedCell,charList,result);
                    storeUsedCell[i][j] = false;
                }
            }
        }
        return result;
    }

    public void searchWord(char[][] board,int row,int column,Node root,boolean[][] usedCell,List<Character> charList,List<String> result){
        if(row >= board.length || column >= board[0].length){
            return;
        }

        if(root.isTerminal){
            String finalResult = charList.stream()
                         .map(String::valueOf)
                         .collect(Collectors.joining());
            result.add(finalResult);
            root.isTerminal = false;
            // return;
        }

        

        int[][] leftRight = new int[][] {
    {-1, 0}, {1, 0}, {0, -1}, {0, 1}
};
        
        for(int i=0;i<leftRight.length;i++){
            int newRow = row + leftRight[i][0];
            int newCol = column + leftRight[i][1];
            if(newRow < board.length && newRow >= 0 && newCol < board[0].length && newCol >= 0 ){
                
                if(root.child.containsKey(board[newRow][newCol]) && usedCell[newRow][newCol] == false){
                   usedCell[newRow][newCol] = true;
                   charList.add(board[newRow][newCol]);
                   searchWord(board,newRow,newCol,root.child.get(board[newRow][newCol]),usedCell,charList,result);
                   usedCell[newRow][newCol] = false;
                   charList.remove(charList.size() - 1);
                }
            }
        }
    }


    public void addWord(String word, Node root) {
        Node curr = root;

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.child.containsKey(ch)){
                curr = curr.child.get(ch);
            }else{
                Node nn = new Node('*',false,new HashMap<>());
                curr.child.put(ch,nn);
                curr = nn;
            }
        }
        curr.isTerminal = true;
    }
}
