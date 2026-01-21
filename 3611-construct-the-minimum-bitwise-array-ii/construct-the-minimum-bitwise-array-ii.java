class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans=new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            int N=nums.get(i);
            if(nums.get(i)!=2){
                ans[i]=N-((N+1)&(-N-1))/2;
            }else ans[i]=-1;
        }
        return ans;
    }
}