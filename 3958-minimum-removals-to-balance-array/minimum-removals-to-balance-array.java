class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0,idx=0,min=Integer.MAX_VALUE;
        while(i<nums.length){
            while(idx<nums.length && (long)nums[i]*k>=(long)nums[idx]){
                idx++;
            }
            min=Math.min(min,i+nums.length-idx);
            i++;
        }
        return min;
    }
}