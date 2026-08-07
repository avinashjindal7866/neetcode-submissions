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
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return result;
    }

    private int height(TreeNode root) {
        if (root == null) return -1;

        int left = height(root.left);
        int right = height(root.right);
        System.out.println(root.val + " " + left + " " + right);
        if(Math.abs(left - right) > 1){
            result = false;
        }
        return Math.max(left, right) + 1;
    }
}
