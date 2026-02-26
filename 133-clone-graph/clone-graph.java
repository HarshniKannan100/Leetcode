/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Map<Node,Node> map=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        map.put(node,new Node(node.val));
        q.add(node);
        while(!q.isEmpty()){
            Node poll=q.poll();
            for(Node n:poll.neighbors){
                if(!map.containsKey(n)){
                    map.put(n,new Node(n.val));
                    q.add(n);
                }
                map.get(poll).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }
}