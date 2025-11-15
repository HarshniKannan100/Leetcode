class Solution {
    public int numberOfSubstrings(String s) {
        int[] dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
        for(int i=0;i<s.length();i++){
            if(i==0 || s.charAt(i-1)=='0') dp[i+1]=i;
            else dp[i+1]=dp[i];
        }
        int count=0;
        for(int i=1;i<=s.length();i++){
            int czero=s.charAt(i-1)=='0'?1:0;
            int j=i;
            while(j>0 && czero*czero<=s.length()){
                int cone=(i-dp[j])-czero;
                if(czero*czero<=cone){
                    count+=Math.min(j-dp[j],cone-czero*czero+1);
                }
                j=dp[j];
                czero++;
            }
        }
        return count;
    }
}