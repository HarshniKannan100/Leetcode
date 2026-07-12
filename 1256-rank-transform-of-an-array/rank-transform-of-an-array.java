class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[][] temp=new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            temp[i][0]=arr[i];
            temp[i][1]=i;
        }
        int idx=0;
        Arrays.sort(temp,(a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<arr.length;i++){
            if(i==0 || temp[i-1][0]!=temp[i][0]) idx++;
            arr[temp[i][1]]=idx;
        }
        return arr;
    }   
}