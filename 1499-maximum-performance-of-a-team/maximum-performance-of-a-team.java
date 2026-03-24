class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD=1000000007;
        int[][] mat=new int[n][2];
        for(int i=0;i<n;i++){
            mat[i][0]=speed[i];
            mat[i][1]=efficiency[i];
        }
        Arrays.sort(mat,(a,b)->Integer.compare(b[1],a[1]));
        Queue<Integer> pq=new PriorityQueue<>();
        long max=0,tot=0;
        for(int i=0;i<n;i++){
            pq.add(mat[i][0]);
            if(pq.size()<=k){
                tot=(tot+mat[i][0]);                
            }else{
                tot=(tot-pq.poll()+mat[i][0]);
            }
            max=Math.max(max,tot*mat[i][1]);
        }
        return (int)(max%(long)(MOD));
    }
}