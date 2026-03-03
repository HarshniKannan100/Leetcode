class Solution {
    void dfs(int[] edges,int node,int d,int[] dis){
        while(node!=-1 && dis[node]==-1){
            dis[node]=d++;
            node=edges[node];
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dis1=new int[edges.length],dis2=new int[edges.length];
        Arrays.fill(dis1,-1);
        Arrays.fill(dis2,-1);
        dfs(edges,node1,0,dis1);
        dfs(edges,node2,0,dis2);
        int min=Integer.MAX_VALUE,idx=-1;
        for(int i=0;i<dis1.length;i++){
            if(dis1[i]>=0 && dis2[i]>=0){
                int dis=Math.max(dis1[i],dis2[i]);
                if(dis<min){
                    min=dis;
                    idx=i;
                }
            }
        }
        return idx;
    }
}