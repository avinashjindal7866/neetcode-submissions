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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return traversal(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode traversal(int[] preorder, int[] inorder,int plo,int phi,int ilo,int ihi){
        if(plo>phi && ilo>ihi){
            return null;
        }
        TreeNode first = new TreeNode(preorder[plo]);
        int idx = search(ilo,ihi,inorder,first.val);
        int c = idx - ilo;
        first.left = traversal(preorder,inorder,plo+1,plo+c,ilo,idx-1);
        first.right = traversal(preorder,inorder,plo+c+1,phi,idx+1,ihi);

        return first;
    }

    public int search(int ilo,int ihi,int[] inorder,int item){
        for(int i=ilo;i<=ihi;i++){
            if(inorder[i] == item){
                return i;
            }
        }
        return 0;
    }
    
}
