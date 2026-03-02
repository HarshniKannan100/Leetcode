class Solution {
    public int minSwaps(int[][] grid) {
        int[] zcount=new int[grid.length];
        for(int i=0;i<grid.length;i++){
            int count=0;
            for(int j=grid.length-1;j>=0 && grid[i][j]==0;j--){
                count++;
            }
            zcount[i]=count;
        }
        int swap=0;
        for(int i=0;i<grid.length;i++){
            int need=grid.length-i-1;
            int j=i;
            while(j<grid.length && zcount[j]<need){
                j++;
            }
            if(j==grid.length) return -1;
            while(j>i){
                int t=zcount[j];
                zcount[j]=zcount[j-1];
                zcount[j-1]=t;
                j--;
                swap++;
            }
        }
        return swap;
    }
}