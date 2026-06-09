class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int mini=0,maxi=0;
        long tot=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<nums[mini]) mini=i;
            else if(nums[i]>nums[maxi]) maxi=i;
        }
        tot=k*((long)nums[maxi]-(long)nums[mini]);
        return tot;
    }
}