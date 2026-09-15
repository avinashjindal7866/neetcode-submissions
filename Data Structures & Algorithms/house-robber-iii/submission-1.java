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
class Solution {
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> dp = new HashMap<>();
        return tree(root, dp);
    }

    public static int tree(TreeNode root,HashMap<TreeNode, Integer> dp){
        if(root == null){
            return 0;
        }

        if(dp.containsKey(root)){
            return dp.get(root);
        }

        int first = root.val;
        int second = 0;
        if(root.left != null){
            first += tree(root.left.right, dp) + tree(root.left.left, dp);
            second += tree(root.left,  dp);   
        }   
        if(root.right != null){
            first += tree(root.right.right, dp) + tree(root.right.left, dp);
            second += tree(root.right,  dp);
        }
        dp.put(root,Math.max(first,second));
        return dp.get(root);
        
    }
}