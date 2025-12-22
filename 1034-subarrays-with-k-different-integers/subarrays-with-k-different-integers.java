class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int left=0,wstart=0,ans=0,right=0,count=0;
        while(right<nums.length){
            if(!map.containsKey(nums[right])){
                count++;
            }
            map.put(nums[right],right);
            if(count>k){
                while(count>k){
                    if(map.get(nums[left])==left){
                        count--;
                        map.remove(nums[left]);
                    }
                    left++;
                }
                wstart=left;
            }
            if(count==k){
                while(map.get(nums[wstart])!=wstart){
                    wstart++;
                }
                ans+=(wstart-left+1);
            }
            right++;
        }
        return ans;
    }
}