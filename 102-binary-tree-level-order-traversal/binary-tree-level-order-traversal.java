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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> q=new LinkedList<>();
        list.add(new ArrayList<>());
        list.get(0).add(root.val);
        q.add(root);
        while(!q.isEmpty()){
            int qsize=q.size();
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<qsize;i++){
                TreeNode poll=q.poll();
                if(poll.left!=null){
                    q.add(poll.left);
                    l.add(poll.left.val);
                }
                if(poll.right!=null){
                    q.add(poll.right);
                    l.add(poll.right.val);
                }
            }
            if(!l.isEmpty()) list.add(l);
        }
        return list;
    }
}
