class Solution {
    int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public int gcdOfOddEvenSums(int n) {
        int sumO=0,sumE=0;
        for(int i=1;i<=n*2;i++){
            if(i%2==0) sumE+=i;
            else sumO+=i;
        }
        return gcd(sumO,sumE);
    }
}