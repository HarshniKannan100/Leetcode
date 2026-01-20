class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=matrix.length,c=matrix[0].length;
        int low=0,high=r-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(matrix[mid][0]<=target && matrix[mid][c-1]>=target){
                int left=0,right=c-1;
                while(left<=right){
                    int m=(left+right)/2;
                    if(matrix[mid][m]==target){
                        return true;
                    }
                    if(matrix[mid][m]>target){
                        right=m-1;
                    }else{
                        left=m+1;
                    }
                }
                return false;
            }
            if(matrix[mid][0]>target){
                high=mid-1;
            }else if(matrix[mid][c-1]<target){
                low=mid+1;
            }
        }
        return false;
    }
}
