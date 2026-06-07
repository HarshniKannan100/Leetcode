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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        for(int[] n:descriptions){
          if(!map.containsKey(n[0])){
            map.put(n[0],new TreeNode(n[0]));
          }
          set.add(n[1]);
          TreeNode nn=map.get(n[0]);
          if(!map.containsKey(n[1])) map.put(n[1],new TreeNode(n[1]));
          TreeNode nc=map.get(n[1]);
          if(n[2]==1) nn.left=nc;
          else nn.right=nc;
        }
        for(int[] n:descriptions){
            if(!set.contains(n[0])) return map.get(n[0]);
        }
        return null;
    }
}