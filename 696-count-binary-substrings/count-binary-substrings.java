class Solution {
    public int countBinarySubstrings(String s) {
        int[] dp=new int[s.length()];
        int in=1,idx=0;
        while(in<s.length()){
            int count=1;
            while(in<s.length() && s.charAt(in-1)==s.charAt(in)){
                in++;
                count++;
            }
            dp[idx++]+=count;
            if(in==s.length()-1) dp[idx]+=1;
            in++;
        }
        int sum=0;
        for(int i=1;i<s.length();i++){
            if(dp[i]==0) break;
            sum+=Math.min(dp[i],dp[i-1]);
        }
        return sum;
    }
}