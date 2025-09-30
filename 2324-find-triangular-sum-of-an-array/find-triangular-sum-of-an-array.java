class Solution {
    public int triangularSum(int[] nums) {
        int n=nums.length;
        while(n!=1){
            int temp=0;
            for(int i=0;i<n-1;i++){
                nums[i]=nums[i]+nums[i+1];
                if(nums[i]>0) nums[i]=nums[i]%10;
            }
            n--;
        }
        return nums[0];
    }
}