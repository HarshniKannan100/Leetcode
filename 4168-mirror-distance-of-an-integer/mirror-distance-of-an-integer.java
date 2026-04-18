class Solution {
    public int mirrorDistance(int n) {
        int t=n,N=0;
        while(t>0){
            N*=10;
            N+=t%10;
            t/=10;
        }
        return Math.abs(n-N);
    }
}