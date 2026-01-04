class Solution {
    public int sumFourDivisors(int[] nums) {
        int tot=0;
        for(int n:nums){
            int sum=n+1;
            int count=2;
            for(int i=2;i<=n/2;i++){
                if(n%i==0){
                    count++;
                    sum+=i;
                }
                if(count>4) break;
            }
            if(count==4) tot+=sum;
        }
        return tot;
    }
}