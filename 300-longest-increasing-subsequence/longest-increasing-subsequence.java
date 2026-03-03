class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0]=nums[0];
        int idx=1;
        for(int i=1;i<nums.length;i++){
            if(dp[idx-1]>=nums[i]){
                int l=0,r=idx-1,mid;
                boolean flag=false;
                while(l<r){
                    mid=(l+r)/2;
                    if(dp[mid]>nums[i]){
                        r=mid;
                    }else if(dp[mid]<nums[i]){
                        l=mid+1;
                    }else{
                        flag=true;
                        break;
                    }
                }
                if(!flag) dp[l]=nums[i];
                
            }else dp[idx++]=nums[i];
        }
        int n=0;
        for(int i=0;i<nums.length;i++){
            if(dp[i]==Integer.MIN_VALUE) break;
            n++;
        }
        return n;
    }
}
