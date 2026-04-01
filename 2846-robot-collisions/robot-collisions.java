public class Node{
    int pos;
    char dir;
    int health;
    int idx;
    public Node(int pos,char dir,int health,int idx){
        this.pos=pos;
        this.dir=dir;
        this.health=health;
        this.idx=idx;
    }
}
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Stack<Node> st=new Stack<>();
        List<Node> list=new ArrayList<>();
        for(int i=0;i<positions.length;i++){
            list.add(new Node(positions[i],directions.charAt(i),healths[i],i));
        }
        Collections.sort(list,(a,b)->Integer.compare(a.pos,b.pos));
        for(Node l:list){
            if(l.dir=='R'){
                st.push(l);
            }else{
                while(!st.isEmpty()){
                    if(st.peek().health>l.health){
                        l.health=0;
                        st.peek().health-=1;
                        break;
                    }else if(st.peek().health<l.health){
                        st.peek().health=0;
                        l.health-=1;
                        st.pop();
                    }else{
                        st.peek().health=0;
                        l.health=0;
                        st.pop();
                        break;
                    }
                }
            }
        }
        int[] res=new int[positions.length];
        for(Node l:list){
            res[l.idx]=l.health;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i:res){
            if(i>0){
                ans.add(i);
            } 
        }
        return ans;
    }
}