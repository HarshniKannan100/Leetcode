class Solution {
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int end=0,max=0,count=0;
        for(int i=0;i<nums.length-1;i++){
            max=Math.max(max,nums[i]+i);
            if(i==end){
                count++;
                end=max;
            }
        }
        return count;
    }
}