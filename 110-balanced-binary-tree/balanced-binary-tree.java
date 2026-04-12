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
    private int dfs(TreeNode root){
        if(root==null) return 0;
        int x=dfs(root.left);
        if(x==-1) return -1;
        int y=dfs(root.right);
        if(y==-1) return -1;
        if(Math.abs(x-y)>1) return -1;
        return Math.max(x,y)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return dfs(root)!=-1;
    }
}