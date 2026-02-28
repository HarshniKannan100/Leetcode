class Solution {
    int func(int[] nums,int s,int e){
        int prev=0,max=0;
        for(int i=s;i<=e;i++){
            int t=Math.max(max,prev+nums[i]);
            prev=max;
            max=t;
        }
        return max;
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        return Math.max(func(nums,0,nums.length-2),func(nums,1,nums.length-1));
    }
}