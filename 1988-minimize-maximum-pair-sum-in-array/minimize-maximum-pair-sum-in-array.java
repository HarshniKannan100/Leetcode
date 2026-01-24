class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int r=nums.length-1;
        int max=0;
        for(int l=0;l<nums.length/2;l++){
            max=Math.max(max,nums[l]+nums[r--]);
        }
        return max;
    }
}