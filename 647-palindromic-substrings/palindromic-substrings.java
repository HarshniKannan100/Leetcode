class Solution {
    public int countSubstrings(String s) {
        int count=0;
        int[][] dp=new int[s.length()+1][s.length()+1];
        for(int len=0;len<s.length();len++){
            for(int idx=0;idx+len<s.length();idx++){
                if(len<3){
                    if(s.charAt(idx)==s.charAt(idx+len)){
                        dp[idx][idx+len]=1;
                        count++;
                    }
                }else{
                    if(s.charAt(idx)==s.charAt(idx+len)){
                        if(dp[idx+1][idx+len-1]!=0){
                            dp[idx][idx+len]=1;
                            count++;
                        }   
                    }
                }
            }
        }
        return count;
    }
}
