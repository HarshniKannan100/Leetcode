class Solution {
    public int minCost(int n, int[][] edges) {
        List<int[]>[] list = new ArrayList[n];
        for(int i=0;i<n;i++){
            list[i]=new ArrayList<>();
        }
        for(int[] e : edges){
            list[e[0]].add(new int[]{e[1],e[2]});
            list[e[1]].add(new int[]{e[0],2*e[2]});
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        pq.add(new int[]{0, 0});
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int d=cur[0], u=cur[1];
            if(d>dist[u]) continue;
            for(int[] e:list[u]){
                int v=e[0],w=e[1];
                if(dist[v]>d+w){
                    dist[v]=d+w;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }
        return dist[n-1]==Integer.MAX_VALUE?-1:dist[n-1];
    }
}
