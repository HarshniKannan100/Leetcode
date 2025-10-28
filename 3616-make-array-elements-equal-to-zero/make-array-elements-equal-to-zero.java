class Solution {
    public int countValidSelections(int[] nums) {
        int presum[]=new int[nums.length];
        int sufsum[]=new int[nums.length];
        presum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            presum[i]=presum[i-1]+nums[i];
        }
        sufsum[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            sufsum[i]=sufsum[i+1]+nums[i];
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(presum[i]==sufsum[i]) count+=2;
                else if(presum[i]==sufsum[i]-1) count+=1;
                else if(presum[i]-1==sufsum[i]) count+=1;
            }
        }
        return count;
    }
}