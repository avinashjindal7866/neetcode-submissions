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
    public boolean isValidBST(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        inorder(root,lst); 
        return isSortedAscending(lst);
    }

    public static boolean isSortedAscending(List<Integer> list) {
        if (list == null || list.size() <= 1) {
            return true;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            System.out.println(list.get(i));
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false; 
            }
        }
        return true;
    }

    public void inorder(TreeNode root, List<Integer> lst){
        if(root == null){
            return;
        }
        inorder(root.left,lst);
        lst.add(root.val);
        inorder(root.right,lst);
    }
}
