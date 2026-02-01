class Node{
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
        this.prev=null;
        this.next=null;
    }
}
class LRUCache {
    int capacity;
    Node left;
    Node right;
    Map<Integer,Node> map;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.left=new Node(0,0);
        this.right=new Node(0,0);
        this.left.next=this.right;
        this.right.prev=this.left;
        this.map=new HashMap<>();
    }
    
    public void remove(Node node){
        Node prev=node.prev;
        Node next=node.next;
        prev.next=next;
        next.prev=prev;
    }

    public void insert(Node node){
        Node prev=this.right.prev;
        prev.next=node;
        node.prev=prev;
        node.next=right;
        this.right.prev=node;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        Node node=new Node(key,value);
        map.put(key,node);
        insert(node);
        if(map.size()>capacity){
            Node lru=this.left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */