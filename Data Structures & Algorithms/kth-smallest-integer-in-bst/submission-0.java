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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> indexList = new ArrayList<>();
        inorderTrivarsal(root,indexList);
        System.out.println(indexList);
        return indexList.get(k-1);
    }

    public void inorderTrivarsal(TreeNode root, List<Integer> l){
        if(root == null){
            return;
        }

        int val = root.val;

        inorderTrivarsal(root.left,l);

        l.add(val);

        inorderTrivarsal(root.right,l);
        
    }
}
