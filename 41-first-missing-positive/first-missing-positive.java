class Solution {
    public int firstMissingPositive(int[] nums) {
        int till=0;
        int idx=0;
        Arrays.sort(nums);
        while(idx<nums.length){
            if(nums[idx]<=0){
                idx++;
                continue;
            }
            if(till+1>=nums[idx]){
                till=nums[idx];
                idx++;
            }else{
                break;
            }
        }
        return till+1;
    }
}