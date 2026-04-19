class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int j=nums2.length-1,max=0;
        for(int i=nums1.length-1;i>=0;i--){
            if(nums1[i]<=nums2[j]) max=Math.max(max,j-i);
            else{
                while(j>i && j>=0 && nums1[i]>nums2[j]){
                    j--;
                }
                if(nums1[i]<=nums2[j]) max=Math.max(max,j-i);
            }
        }
        return max;
    }
}