class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n=prices.length;
        long[] normPreSum=new long[n];
        long[] stratPreSum=new long[n];
        normPreSum[0]=prices[0];
        stratPreSum[0]=prices[0]*strategy[0];
        for(int i=1;i<n;i++){
            normPreSum[i]=prices[i]+normPreSum[i-1];
            stratPreSum[i]=stratPreSum[i-1]+(prices[i]*strategy[i]);
        }
        long max=stratPreSum[n-1];
        if(n<k) return max;
        for(int i=k-1;i<n;i++){
            long val=normPreSum[i]-normPreSum[i-(k/2)]+stratPreSum[n-1]-stratPreSum[i];
            val+=(i-k<0)?0:stratPreSum[i-k];
            max=Math.max(max,val);
        }
        return max;
    }
}