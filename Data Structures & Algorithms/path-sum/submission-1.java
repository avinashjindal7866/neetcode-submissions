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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root,targetSum,0);
    }

    public boolean pathSum(TreeNode root,int targetSum, int inital) {
        if (root == null) {
            return false;
        }
        
        
        if(inital == 0){
            inital = root.val;
        }else{
            inital += root.val;
        }

        if (root.left == null && root.right == null) {
            return targetSum == inital ? true : false;
        }

        boolean val = pathSum(root.left,targetSum,inital);
        if(val){
            return true;
        }
        return pathSum(root.right,targetSum,inital);
    }
    
}