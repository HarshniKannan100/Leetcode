class Solution {
    public int removeCoveredIntervals(int[][] arr) {
        Arrays.sort(arr,(a,b)->a[0]==b[0]?Integer.compare(b[1],a[1]):Integer.compare(a[0],b[0]));
        int cnt=0,b=0;
        for(int i=0;i<arr.length;i++){
            if( b<arr[i][1]){
                b=arr[i][1];
                cnt++;
            }
        }
        return cnt;
    }
}