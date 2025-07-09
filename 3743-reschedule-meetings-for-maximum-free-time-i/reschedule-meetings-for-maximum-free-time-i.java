class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n=startTime.length;
        int prefixSum[]=new int[n+1];
        for(int i=0;i<n;i++){
            prefixSum[i+1]=prefixSum[i]+endTime[i]-startTime[i];
        }   
        int maxFree=0;
        for(int i=k-1;i<n;i++){
            int occupied=prefixSum[i+1]-prefixSum[i-k+1];
            int start=(i==k-1)?0:endTime[i-k];
            int end=(i==n-1)?eventTime:startTime[i+1];
            int freeSpace=end-start-occupied;
            maxFree=Math.max(maxFree,freeSpace);
        }
        return maxFree;
    }
}