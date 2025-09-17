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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        list.add(new ArrayList<>());
        if(root==null) return new ArrayList<>();
        list.get(0).add(root.val);

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> l=new ArrayList<>();
                int level=q.size();
                for(int k=0;k<level;k++){
                    TreeNode pe=q.poll();
                if(pe.left!=null){
                    q.add(pe.left);
                    l.add(pe.left.val);
                }
                if(pe.right!=null){
                    q.add(pe.right);
                    l.add(pe.right.val);
                }
                }
                if(l.size()!=0) list.add(l); 
        }
        int i=0;
        for(List<Integer> l:list){
            if(i%2!=0){
                Collections.reverse(l);
            }
            i++;
        }
        return list;
    }
}