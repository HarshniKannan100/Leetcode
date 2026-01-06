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
    public int maxLevelSum(TreeNode root) {
        int max=root.val;
        int maxL=1;
        int L=1;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int qsize=q.size();
            int sum=0;
            for(int i=0;i<qsize;i++){
                TreeNode pe = q.poll();
                sum+=pe.val;

                if(pe.left!=null){
                    q.add(pe.left);
                }
                if(pe.right!=null){
                    q.add(pe.right);
                }
            }
            if(sum>max){
                max=sum;
                maxL=L;
            }
            L++;
        }
        return maxL;
    }
}