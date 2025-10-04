class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int l=0,r=n-1,left=height[l],right=height[r],slots,max=0,cmax=0;
        while(l<r){
            slots=r-l;
            left=height[l];
            right=height[r];
            cmax=Math.min(left,right)*slots;
            max=Math.max(max,cmax);
            if(left<right){
                l++;
            }else{
                r--;
            }



        }return max;
    }
}