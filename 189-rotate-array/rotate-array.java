class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        int left=0,right=n-k-1;
        while(left<right){
            swap(nums,left,right);
            left++;
            right--;
        }

        left=n-k;
        right=nums.length-1;
        while(left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
        
        left=0;
        right=n-1;
        while(left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    public void swap(int[] nums,int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}