class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int idx=1;
        int cur=1;
        while(idx<arr.length){
            if(arr[idx]>=cur+1){
                arr[idx]=cur+1;
                cur++;
            }
            idx++;
        }
        return cur;
    }
}