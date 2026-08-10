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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return find(root,subRoot);
    }

    public boolean find(TreeNode root,TreeNode subRoot) {
        if (root == null) return false;

        if (isTree(root,subRoot)) return true;

        boolean result = find(root.left, subRoot);
        if(result){
            return true;
        }

        return find(root.right, subRoot);
    }

    public boolean isTree(TreeNode p, TreeNode q){

        if (p == null && q == null) {
            return true;
        }

        if(p != null && q != null){
            if(p.val == q.val){
                boolean val1 = isTree(p.left,q.left);
                boolean val2 = isTree(p.right,q.right);
                return val1 && val2;
            }else{
                return false;
            }
        }else{
            return  false;
        }
    }
}
