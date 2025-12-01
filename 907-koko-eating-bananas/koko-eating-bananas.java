class Solution {
    long check(int v,int[] piles){
        long sum=0;
        for(int n:piles){
            sum+=(n/v);
            if(n%v!=0) sum++;
        }
        return sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        Arrays.sort(piles);
        int right=piles[piles.length-1];
        int ans=right;
        while(left<=right){
            int mid=left+(right-left)/2;
            long res=check(mid,piles);
            if(res<=h){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }

}