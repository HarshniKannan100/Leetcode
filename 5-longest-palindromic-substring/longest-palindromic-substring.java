class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        int max=1,st=0,end=0;
        for(int len=0;len<n;len++){
            for(int indx=0;indx+len<n;indx++){
                if(len<3){
                    if(s.charAt(indx)==s.charAt(indx+len)){
                        dp[indx][indx+len]=1;
                        max=len+1;
                        st=indx;
                        end=indx+len;
                    }else{
                        dp[indx][indx+len]=0;
                    }
                }else{
                    if(s.charAt(indx)==s.charAt(indx+len)){
                        if(dp[indx+1][indx+len-1]==1){
                            dp[indx][indx+len]=1;
                            max=len+1;
                            st=indx;
                            end=indx+len;
                        }
                    }else{
                            dp[indx][indx+len]=0;
                        }
                }
            }
        }
        return s.substring(st,end+1);
    }
}