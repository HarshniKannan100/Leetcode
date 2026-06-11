class Solution {
    int MOD=1000000007;
    public int dfs(int node,int par,List<List<Integer>> list){
        int max=0;
        for(int n:list.get(node)){
            if(n==par) continue;
            max=(Math.max(max,dfs(n,node,list)));
        }
        return max+1;
    }
    public int assignEdgeWeights(int[][] edges) {
        List<List<Integer>> list=new ArrayList<>();
        int n=1;
        for(int i=0;i<edges.length;i++){
            n=Math.max(n,edges[i][0]);
            n=Math.max(n,edges[i][1]);
        }
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] e:edges){
            list.get(e[0]-1).add(e[1]-1);
            list.get(e[1]-1).add(e[0]-1);
        }
        int res=(dfs(0,-1,list));
        long ans=1;
        long base=2;
        int exp=res-2;
        while(exp>0){
            if((exp&1)==1) ans=(ans*base)%MOD;
            base=(base*base)%MOD;
            exp>>=1;
        }
        return (int)ans;
    }
}