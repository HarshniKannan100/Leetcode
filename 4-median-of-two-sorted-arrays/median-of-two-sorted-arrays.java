class Solution {
    int getKth(int m,int[] a,int n,int[] b,int k,int p1,int p2){
        if(m>n) return getKth(n,b,m,a,k,p2,p1);
        if(m==0) return b[p2+k-1];
        if(k==1) return Math.min(a[p1],b[p2]);
        int i=Math.min(m,k/2);
        int j=Math.min(n,k/2);
        if(a[p1+i-1]<=b[p2+j-1]){
            return getKth(m-i,a,n,b,k-i,p1+i,p2);
        }else return getKth(m,a,n-j,b,k-j,p1,p2+j);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length+nums2.length;
        return (getKth(nums1.length,nums1,nums2.length,nums2,(n+1)/2,0,0)+getKth(nums1.length,nums1,nums2.length,nums2,(n+2)/2,0,0))/2.0;
    }
}