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
    private boolean dfs(TreeNode p,TreeNode q){
        if(p==null && q==null) return true;
        if((p==null && q!=null) || (p!=null && q==null)) return false;
        boolean left=dfs(p.left,q.left);
        if(left==false) return false;
        boolean right=dfs(p.right,q.right);
        if(right==false) return false;
        if(p.val==q.val) return true;
        return false;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q);
    }
}
