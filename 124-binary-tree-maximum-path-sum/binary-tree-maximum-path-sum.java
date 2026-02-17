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
    int ans=-1;
    int dfs(TreeNode node){
        if(node==null) return 0;
        int leftmax=Math.max(dfs(node.left),0);
        int rightmax=Math.max(dfs(node.right),0);
        ans=Math.max(ans,node.val+leftmax+rightmax);
        return node.val+Math.max(leftmax,rightmax);
    }
    public int maxPathSum(TreeNode root) {
        ans=root.val;
        dfs(root);
        return ans;
    }
}
