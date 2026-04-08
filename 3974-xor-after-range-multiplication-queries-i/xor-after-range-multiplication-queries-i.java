class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD=1000000007;
        for(int[] q:queries){
            int l=q[0],r=q[1],v=q[3],k=q[2];
            while(l<=r){
                nums[l]=(int)((1L*nums[l]*v)%MOD);
                l+=k;
            }
        }
        int v=nums[0];
        for(int i=1;i<nums.length;i++){
            v^=nums[i];
        }
        return v;
    }
}