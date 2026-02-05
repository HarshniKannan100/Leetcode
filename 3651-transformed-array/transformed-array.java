class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int N=nums.length;
        int[] res=new int[N];
        for(int i=0;i<N;i++){
            if(nums[i]==0) res[i]=0;
            else{
                res[i]=nums[i]>0?nums[(i+nums[i]+N)%N]:nums[(i+nums[i]%N+N)%N];
            }
        }
        return res;
    }
}