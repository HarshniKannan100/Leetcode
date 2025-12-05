class Solution {
    public int countPartitions(int[] nums) {
        int count=0;
        int lsum=0,rsum=0;
        for(int i=0;i<nums.length;i++){
            rsum+=nums[i];
        }
        for(int i=0;i<nums.length-1;i++){
            lsum+=nums[i];
            rsum-=nums[i];
            if((lsum-rsum)%2==0) count++;
        }
        return count;
    }
}