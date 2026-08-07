/**1
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
    public TreeNode invertTree(TreeNode root) {
        preOrder(root);
        return root;
    }

    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode temp = convert(root);
        preOrder(temp.left);
        preOrder(temp.right);
    }

    public TreeNode convert(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
