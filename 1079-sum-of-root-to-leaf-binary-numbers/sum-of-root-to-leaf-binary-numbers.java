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
    int bit(String s){
        int v=0;
        for(int i=0;i<s.length();i++){
            v|=((s.charAt(i)=='1')?1:0);
            v<<=1;
        }
        v>>=1;
        System.out.println(v);
        return v;
    }
    int dfs(TreeNode node,StringBuilder sb){
        if(node==null) return 0;
        sb.append(node.val);
        int sum=0;
        if(node.left==null && node.right==null){
            sum=bit(sb.toString());
        }else{
            sum=dfs(node.left,sb)+dfs(node.right,sb);
        }
        sb.deleteCharAt(sb.length()-1);
        return sum;
    }
    public int sumRootToLeaf(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        return dfs(root,sb);
    }
}