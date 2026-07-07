class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        int num=0;
        while(n>0){
            if(n%10!=0){
                num=(num*10)+n%10;
                sum+=n%10;
            }
            n/=10;
        }
        long x=0;
        while(num>0){
            x=x*10+num%10;
            num/=10;
        }
        return x*sum;
    }
}