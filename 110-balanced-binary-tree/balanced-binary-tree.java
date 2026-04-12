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
    boolean bal=true;
    private int dfs(TreeNode root,int x,int y){
        if(root==null) return 0;
        x=dfs(root.left,x,y);
        y=dfs(root.right,x,y);
        if(Math.abs(x-y)>1) bal=false;
        return Math.max(x,y)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int a=dfs(root,0,0);
        return bal;
    }
}