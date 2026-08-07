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
    boolean re = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        isTree(p,q);
        return isTree(p,q);
    }

    public boolean isTree(TreeNode p, TreeNode q){

        if (p == null && q == null) {
            return true;
        }

        if(p != null && q != null){
            if(p.val == q.val){
                boolean val1 = isSameTree(p.left,q.left);
                boolean val2 = isSameTree(p.right,q.right);
                return val1 && val2;
            }else{
                return false;
            }
        }else{
            return  false;
        }
    }
}
