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
    int count=0;
    void dfs(TreeNode node,int max){
        if(node==null) return;
        if(node.val>max){
            max=node.val;
        }
        if(node.val==max) count++;
        dfs(node.left,max);
        dfs(node.right,max);
    }
    public int goodNodes(TreeNode root) {
        int max=root.val;
        dfs(root,max);
        return count;
    }
}