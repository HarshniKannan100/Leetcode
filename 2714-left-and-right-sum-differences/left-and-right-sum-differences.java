class Solution {
    public int[] leftRightDifference(int[] nums) {
        int rsum=0,n=nums.length;
        int[] arr=new int[n];
        arr[0]=nums[0];
        for(int i=1;i<n;i++){
            arr[i]=nums[i]+arr[i-1];
        }
        for(int i=n-1;i>=0;i--){
            rsum+=nums[i];
            arr[i]=Math.abs(arr[i]-rsum);
        }
        return arr;
    }
}