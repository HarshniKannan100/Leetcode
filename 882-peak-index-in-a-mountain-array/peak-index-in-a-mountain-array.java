class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l=0,r=arr.length-1;
        while(l<r){
            int mid=(l+r)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }else if(arr[mid]<arr[mid-1]){
                r--;
            }else l++;
        }
        return 0;
    }
}