class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int n:piles){
            max=Math.max(max,n);
        }
        int left=1,right=max,res=max;
        while(left<=right){
            int mid=(left+right)/2;
            long count=0;
            for(int n:piles){
                count+=(n/mid)+(n%mid!=0?1:0);
            } 
            if(count<=h){
                res=mid;
                right=mid-1;
            }
            else left=mid+1;
        }
        return res;
    }
}
