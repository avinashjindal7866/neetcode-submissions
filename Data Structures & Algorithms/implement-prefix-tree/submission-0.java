class PrefixTree {

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

    public PrefixTree() {
        root = new Node('*',false,new HashMap<>());
    }

    public void insert(String word) {
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
            if(curr.child.containsKey(ch)){
                curr = curr.child.get(ch);
            }else{
                return false;
            }
        }
        return curr.isterminal;
    }

    public boolean startsWith(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.child.containsKey(ch)){
                curr = curr.child.get(ch);
            }else{
                return false;
            }
        }
        return true;
    }
}
