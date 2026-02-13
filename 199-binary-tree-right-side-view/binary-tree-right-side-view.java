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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        q.add(root);
        while(!q.isEmpty()){
            int qsize=q.size();
            for(int i=0;i<qsize;i++){
                TreeNode poll=q.poll();
                if(i==qsize-1){
                    list.add(poll.val);
                }
                if(poll.left!=null){
                    q.add(poll.left);
                }
                if(poll.right!=null){
                    q.add(poll.right);
                }
            }
        }
        return list;
    }
}
