class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int last1=-1,idx=0;
        while(idx<nums.length){
            if(nums[idx]==1){
                last1=idx;
                break;
            }
            idx++;
        }
        for(int i=last1+1;i<nums.length;i++){
            if(nums[i]==1 && i-k>last1) last1=i;
            else if(nums[i]==0) continue;
            else return false;
        }
        return true;
    }
}