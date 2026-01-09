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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root==null) return null;
        Map<TreeNode,TreeNode> parent=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        parent.put(root,null);

        List<TreeNode> last=new ArrayList<>();
        while(!q.isEmpty()){
            int qsize=q.size();
            last.clear();
            for(int i=0;i<qsize;i++){
                TreeNode node=q.poll();
                last.add(node);
                if(node.left!=null){
                    q.add(node.left);
                    parent.put(node.left,node);
                }
                if(node.right!=null){
                    q.add(node.right);
                    parent.put(node.right,node);
                }
            }
        }
        Set<TreeNode> deepest=new HashSet<>(last);
        while(deepest.size()>1){
            Set<TreeNode> set=new HashSet<>();
            for(TreeNode node:deepest){
                set.add(parent.get(node));
            }
            deepest=set;
        }
        for(TreeNode node:deepest) return node;
        return null;
    }
}