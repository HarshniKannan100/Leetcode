class Solution {
    public int numOfWays(int n) {
        int MOD=1000000007;
        long a=6,b=6;
        for(int i=1;i<n;i++){
            long A=(2*a+2*b)%MOD;
            long B=(2*a+3*b)%MOD;
            a=A;
            b=B;
        }
        return (int)((a+b)%MOD);
    }
}