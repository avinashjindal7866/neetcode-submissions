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
    int max = Integer.MIN_VALUE; 
    public int maxPathSum(TreeNode root) {
        preOrder(root);
        return max;
    }
    public int preOrder(TreeNode root){
        if(root == null){
            return -1;
        }
        // check(root);
        int left = preOrder(root.left);
        int right = preOrder(root.right);
        int leftF = Math.max(0,left);
        int rightF = Math.max(0,right);
        System.out.println(root.val+leftF+rightF);
        max = Math.max(max,root.val+leftF+rightF);
        return         root.val + Math.max(leftF, rightF);

    }
}
