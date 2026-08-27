/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        dfs(node);
        return map.get(1);

    }

    private Node dfs(Node r){
        if(r == null){
            return null;
        }

        if(map.containsKey(r.val)){
            return map.get(r.val);
        }

        Node clone = new Node(r.val);
        map.put(r.val,clone);

        for(Node n : r.neighbors){
            clone.neighbors.add(dfs(n));
        }

        return clone;
    }
}