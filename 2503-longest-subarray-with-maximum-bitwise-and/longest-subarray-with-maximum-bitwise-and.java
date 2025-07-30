class Solution {
    public int longestSubarray(int[] nums) {
        int maxval=0;
        for(int n:nums){
            if(n>maxval) maxval=n;
        }
        int cur=0;
        int max=0;
        for(int n:nums){
            if(n==maxval) cur++;
            else{
                max=Math.max(max,cur);
                cur=0;
            }
        }
        return Math.max(cur,max);
    }
}