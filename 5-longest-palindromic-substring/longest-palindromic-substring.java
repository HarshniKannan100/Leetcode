class Solution {
    public String longestPalindrome(String s) {
        int max=1;
        int[][] dp=new int[s.length()+1][s.length()+1];
        String res=s.substring(0);
        for(int len=0;len<s.length();len++){
            for(int idx=0;idx+len<s.length();idx++){
                if(len<3){
                    if(s.charAt(idx)==s.charAt(idx+len)){
                        dp[idx][idx+len]=1;
                        max=len+1;
                        res=s.substring(idx,idx+len+1);
                    }
                }else{
                    if(s.charAt(idx)==s.charAt(idx+len)){
                        if(dp[idx+1][idx+len-1]!=0){
                            dp[idx][idx+len]=1;
                            max=len+1;
                            res=s.substring(idx,idx+len+1);
                        }   
                    }
                }
            }
        }
        return res;
    }
}
