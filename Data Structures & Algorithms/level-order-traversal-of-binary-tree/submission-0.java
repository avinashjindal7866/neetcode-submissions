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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> qb = new LinkedList<>();
        qb.add(root);
        while(!qb.isEmpty()){
            q = qb;
            qb = new LinkedList<>();
            List<Integer> inside = new ArrayList<>();
            while(!q.isEmpty()){
                TreeNode r = q.poll();
                inside.add(r.val);
                if(r.left != null){
                    qb.add(r.left);
                }
                if(r.right != null){
                    qb.add(r.right);
                }
            }
            
            result.add(inside);
        }
        return result;
    }
}
