class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] mat=new int[nums1.length][nums2.length];
        int[][] dp=new int[nums1.length][nums2.length];
        for(int r=0;r<nums1.length;r++){
            for(int c=0;c<nums2.length;c++){
                mat[r][c]=nums1[r]*nums2[c];
            }
        }

        dp[0][0]=mat[0][0];
        for(int c=1;c<nums2.length;c++){
            dp[0][c]=Math.max(mat[0][c],dp[0][c-1]);
        }
        for(int r=1;r<nums1.length;r++){
            dp[r][0]=Math.max(mat[r][0],dp[r-1][0]);
        }
        for(int r=1;r<nums1.length;r++){
            for(int c=1;c<nums2.length;c++){
                dp[r][c]=Math.max(mat[r][c],dp[r-1][c-1]+mat[r][c]);
                dp[r][c]=Math.max(dp[r][c],dp[r-1][c]);
                dp[r][c]=Math.max(dp[r][c],dp[r][c-1]);
            }
        }
        return dp[nums1.length-1][nums2.length-1];
    }
}