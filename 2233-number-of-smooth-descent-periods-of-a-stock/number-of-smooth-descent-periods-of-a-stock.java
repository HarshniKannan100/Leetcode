class Solution {
    long func(long n){
        long val=1,inc=2;
        for(int i=1;i<n;i++){
            val+=inc;
            inc++;
        }
        return val;
    }
    public long getDescentPeriods(int[] prices) {
        long tot=0,count=1;
        int idx=1,val=0;
        while(idx<prices.length){
            if(prices[idx]+1==prices[idx-1]){
                while(idx<prices.length && prices[idx]+1==prices[idx-1]){
                    count++;
                    idx++;
                }
                tot+=func(count);
                val+=count;
                count=1;
            }else idx++;
        }
        return tot+(prices.length-val);
    }
}