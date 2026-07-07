class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder sb=new StringBuilder();
        long sum=0;
        while(n>0){
            if(n%10!=0) sb.append(n%10);
            sum+=n%10;
            n/=10;
        }
        sb.reverse();
        long x=0;
        if(sb.length()!=0) x=Integer.parseInt(sb.toString());
        return x*sum;
    }
}