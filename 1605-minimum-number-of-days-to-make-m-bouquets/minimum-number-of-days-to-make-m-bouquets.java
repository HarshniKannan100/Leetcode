class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        int N=bloomDay.length;
        if(N/k<m) return -1;
        for(int i=0;i<N;i++){
            min=Math.min(min,bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
        }
        int totcount=0;
        while(min<=max){
            int mid=(min+max)/2;
            int count=0;
            totcount=0;
            for(int i=0;i<N;i++){
                if(bloomDay[i]<=mid) count++;
                else{
                    totcount+=(count/k);
                    count=0;
                }
            }
            totcount+=(count/k);
            System.out.println(totcount);
            if(totcount<m){
                min=mid+1;
            }else{
                max=mid-1;
            }
        }
        return min;
    }
}