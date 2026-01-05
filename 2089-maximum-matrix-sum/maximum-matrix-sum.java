class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        int min=Integer.MAX_VALUE;
        int negCount=0;
        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix[0].length;c++){
                sum+=Math.abs(matrix[r][c]);
                min=Math.min(min,Math.abs(matrix[r][c]));
                if(matrix[r][c]<0) negCount++;
            }
        }
        if(negCount%2==0) return sum;
        return sum-2*min;
    }
}