class Solution {
    int size;
    int[] segMax,segMin;
    public int[] query(int l,int r){
        int max=0,min=Integer.MAX_VALUE;
        for(l+=size,r+=size;l<=r;l/=2,r/=2){
            if(l%2==1){
                max=Math.max(max,segMax[l]);
                min=Math.min(min,segMin[l]);
                l++;
            }
            if(r%2==0){
                max=Math.max(max,segMax[r]);
                min=Math.min(min,segMin[r]);
                r--;
            }
        }
        return new int[]{max,min};
    }
    public long maxTotalValue(int[] nums, int k) {
        int n=nums.length;
        size=1;
        while(size<n){
            size*=2;
        }
        segMax=new int[2*size];
        segMin=new int[2*size];
        Arrays.fill(segMin,Integer.MIN_VALUE);
        for(int i=0;i<n;i++){
            segMax[size+i]=segMin[size+i]=nums[i];
        }
        for(int i=size-1;i>0;i--){
            segMax[i]=Math.max(segMax[2*i],segMax[2*i+1]);
            segMin[i]=Math.min(segMin[2*i],segMin[2*i+1]);
        }
        Queue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int l=0;l<n;l++){
            int[] res=query(l,n-1);
            pq.add(new int[]{res[0]-res[1],l,n-1});
        }
        long ans=0;
        for(int i=0;i<k;i++){
            int[] top=pq.poll();
            ans+=top[0];
            if(top[2]>top[1]){
                int[] res=query(top[1],top[2]-1);
                pq.add(new int[]{res[0]-res[1],top[1],top[2]-1});
            }
        }
        return ans;
    }
}