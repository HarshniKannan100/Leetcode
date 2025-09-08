class Solution {
    static boolean invalid(int n){
        while(n>0){
            if(n%10==0) return true;
            n/=10;
        }
        return false;
    }
    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<n;i++){
        int j=n-i;
        if(!invalid(i) && !invalid(j)){
            return new int[]{i,j};
        }
        }
        return new int[0];
    }
}