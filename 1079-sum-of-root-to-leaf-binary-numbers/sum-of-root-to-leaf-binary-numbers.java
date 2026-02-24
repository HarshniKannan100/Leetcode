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
    int dfs(TreeNode node,int v){
        if(node==null) return 0;
        v<<=1;
            v|=node.val;
        if(node.left==null && node.right==null){
            return v;
        }
        return dfs(node.left,v)+dfs(node.right,v);
    }
    public int sumRootToLeaf(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        return dfs(root,0);
    }
}