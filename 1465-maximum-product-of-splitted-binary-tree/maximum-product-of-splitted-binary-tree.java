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
    long sum=0;
    long max=0;
    long traverse(TreeNode root){
        if (root == null) return 0;
        long left = traverse(root.left);
        long right = traverse(root.right);
        long cursum = left + right + root.val;
        max = Math.max(max, cursum * (sum - cursum));
        return cursum;
    }
    void findsum(TreeNode root){
        if(root==null) return;
        findsum(root.left);
        findsum(root.right);
        sum+=root.val;
    }
    public int maxProduct(TreeNode root) {
        findsum(root);
        traverse(root);
        return (int)(max % 1000000007);
    }
}