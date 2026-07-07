class Solution {
    public int firstMissingPositive(int[] nums) {
        int N=nums.length;
        for(int i=0;i<N;i++){
            while(nums[i]>0 && nums[i]<=N && nums[nums[i]-1]!=nums[i]){
                int temp=nums[i];
                nums[i]=nums[temp-1];
                nums[temp-1]=temp;
            }
        }
        for(int i=0;i<N;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return N+1;
    }
}