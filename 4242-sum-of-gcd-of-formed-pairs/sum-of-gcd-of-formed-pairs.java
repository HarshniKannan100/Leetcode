class Solution {
    int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public long gcdSum(int[] nums) {
        int N=nums.length;
        int[] prefixGcd=new int[N];
        int max=0;
        for(int i=0;i<N;i++){
            max=Math.max(max,nums[i]);
            prefixGcd[i]=gcd(nums[i],max);
        }
        long sum=0;
        Arrays.sort(prefixGcd);
        for(int i=0;i<N/2;i++){
            sum+=gcd(prefixGcd[i],prefixGcd[N-i-1]);
        }
        return sum;
    }
}