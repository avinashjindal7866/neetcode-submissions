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
    int initial = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        rangeAlpha(root,low,high);
        return initial;
    }

    public void rangeAlpha(TreeNode root, int low, int high){
        if(root == null){
            return;
        }

        if(root.val >= low && root.val <= high){
            initial += root.val;
        }

        rangeAlpha(root.left, low, high);
        rangeAlpha(root.right,low, high);
    }
}