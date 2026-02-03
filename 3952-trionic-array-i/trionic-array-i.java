class Solution {
    public boolean isTrionic(int[] nums) {
        int count=0;
        int idx=0;
        boolean flag=false;
        while(idx+1<nums.length){
            if(nums[idx+1]>nums[idx]){
                idx++;
                flag=true;
            }else break;
        }
        if(flag) count+=1;
        flag=false;
        while(idx+1<nums.length){
            if(nums[idx+1]<nums[idx]){
                idx++;
                flag=true;
            }else break;
        }
        if(flag) count+=1;
        flag=false;
        while(idx+1<nums.length){
            if(nums[idx+1]>nums[idx]){
                idx++;
                flag=true;
            }else{
                flag=false;
                break;
            }
        }
        if(flag) count+=1;
        if(count==3) return true;
        return false;

    }
}