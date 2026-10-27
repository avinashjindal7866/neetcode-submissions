class WordDictionary {

    class Node{
        char ch;
        boolean isterminal = false;
        HashMap<Character,Node> child;

        Node(char ch, boolean isTerminal, HashMap<Character, Node> child) {
            this.ch = ch;
            this.isterminal = isTerminal;
            this.child = child;
        }
    }

    private Node root;

    public WordDictionary() {
        root = new Node('*',false,new HashMap<>());
    }

    public void addWord(String word) {
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
        curr.isterminal = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ch == '.'){
                return searchDot( word,curr,i);
            }else if(curr.child.containsKey(ch)){
                curr = curr.child.get(ch);
            }
            else{
                return false;
            }
        }
        return curr.isterminal;
    }

    private boolean searchDot(String word, Node curr,int index){
        StringBuilder sb = new StringBuilder(word);

        boolean finalResult = false;

        for(char c : curr.child.keySet()){
            sb.setCharAt(index, c);
            String result = sb.toString();
            finalResult = search(result);
            if(finalResult){
                return finalResult;
            }
        }

        return finalResult;
    }
}
