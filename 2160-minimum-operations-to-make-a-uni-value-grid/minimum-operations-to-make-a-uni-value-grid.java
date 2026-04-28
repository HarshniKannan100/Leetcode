class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] arr=new int[grid.length*grid[0].length];
        int i=0;
        for(int[] r:grid){
            for(int v:r){
                arr[i++]=v;
            }
        }
        Arrays.sort(arr);
        for(int v:arr){
            if((Math.abs(v-arr[0])%x!=0)) return -1;
        }
        int mid=arr[arr.length/2];
        int count=0;
        for(int v:arr){
            count+=Math.abs((v-mid)/x);
        }
        return count;
    }
}