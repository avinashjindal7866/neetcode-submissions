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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    if (root == null) {
        return null;
    }

    if (p.val < root.val && q.val < root.val) {
        return lowestCommonAncestor(root.left, p, q);
    }

    if (p.val > root.val && q.val > root.val) {
        return lowestCommonAncestor(root.right, p, q);
    }

    return root;
}

    public TreeNode recursion(TreeNode root, TreeNode p, TreeNode q){

        if(root == null){
            return null;
        }


        int leftVal = 0;
        int rightVal = 0;
            if(root.left != null){
                leftVal = root.left.val;
            }
            if(root.right != null){
                rightVal = root.right.val;
            }

            if(p.val == leftVal && q.val == rightVal || p.val == rightVal && q.val == leftVal){
                return root;
            }

        if(p.val == root.val || q.val == root.val){
            return root;
        }


        if(p.val < root.val && q.val < root.val){
           return recursion(root.left,p,q);
        }

        
            return recursion(root.right,p,q);
        
        
    }

}
