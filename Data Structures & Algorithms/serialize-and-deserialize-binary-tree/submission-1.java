/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
        return "null";
    }

    StringBuilder result = new StringBuilder();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
        TreeNode node = q.poll();

        if (node == null) {
            result.append("null,");
            continue;
        }

        result.append(node.val).append(",");

        q.add(node.left);
        q.add(node.right);
    }

    result.setLength(result.length() - 1); // Remove trailing comma
    return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if (data == null || data.equals("null") || data.isEmpty()) {
            return null;
        }

        String[] fruits = data.split(","); 
        Queue<String> q = new LinkedList<>();
        for(String s : fruits){
            
            q.add(s);
        }
    


        String sb = q.poll();
        int number = Integer.parseInt(sb);
        TreeNode root = new TreeNode(number);

        createLevelOrder(root,q);



        return root;
    }


    public void createLevelOrder(TreeNode root, Queue<String> q){

        Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);

    while (!nodes.isEmpty() && !q.isEmpty()) {

        TreeNode current = nodes.poll();

        String left = q.poll();
        String right = q.isEmpty() ? "null" : q.poll();

        if (!left.equals("null")) {
            current.left = new TreeNode(Integer.parseInt(left));
            nodes.add(current.left);
        }

        if (!right.equals("null")) {
            current.right = new TreeNode(Integer.parseInt(right));
            nodes.add(current.right);
        }
        }
    }
}
