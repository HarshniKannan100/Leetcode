class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        long[] mul=new long[nums.length];
        for(int i=0;i<nums.length;i++){
            mul[i]=(long)nums[i]*k;
        }
        int i=0,idx=0,min=Integer.MAX_VALUE;
        while(i<nums.length){
            while(idx<nums.length && mul[i]>=nums[idx]){
                idx++;
            }
            min=Math.min(min,i+nums.length-idx);
            i++;
        }
        return min;
    }
}