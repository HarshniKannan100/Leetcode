class Solution {
    int maxF(int[] arr){
        int max=1,streak=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]==1){
                streak++;
                max=Math.max(max,streak);
            }
            else streak=1;
        }
        return ++max;
    }
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        min=Math.min(maxF(hBars),maxF(vBars));
        return min*min;
    }
}