class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int[][] up=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    if(i==0){
                        up[i][j]=1;
                    }else{
                        up[i][j]=up[i-1][j]+1;
                    }
                }
            }
        }

        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int height=up[i][j];
                int left=j,right=j;
                while(left-1>=0 && up[i][left-1]>=height){
                    left--;
                }
                while(right+1<n && up[i][right+1]>=height){
                    right++;
                }
                int width=right-left+1;
                max=Math.max(max,height*width);
            }
        }
        return max;
    }
}