class Solution {
    public boolean valid(String s1, String s2, String s3, int p1,int p2,int p3,Boolean[][] dp){
        if(p3==s3.length()) return true;
        if(dp[p1][p2]!=null) return dp[p1][p2];
        if(p1<s1.length() && p2<s2.length() && s1.charAt(p1)==s3.charAt(p3) && s2.charAt(p2)==s3.charAt(p3)){
            boolean res=valid(s1,s2,s3,p1+1,p2,p3+1,dp);
        if(res){
            dp[p1][p2]=true;
            return true;
        }
        res= valid(s1,s2,s3,p1,p2+1,p3+1,dp);
        dp[p1][p2]=res;
        return res;
        }else if(p1<s1.length() && s1.charAt(p1)==s3.charAt(p3)){
            boolean res= valid(s1,s2,s3,p1+1,p2,p3+1,dp);
            if(p1<s1.length())
                dp[p1][p2]=res;
            return res;
        }else if(p2<s2.length() && s2.charAt(p2)==s3.charAt(p3)){
            boolean res= valid(s1,s2,s3,p1,p2+1,p3+1,dp);
            if(p2<s2.length())
                dp[p1][p2]=res;
            return res;
        }else{
            if(p1<s1.length() && p2<s2.length())
                dp[p1][p2]=false;
            return false;
        }
        
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1=s1.length();
        int n2=s2.length();
        int n3=s3.length();
        Boolean dp[][]=new Boolean[s1.length()+1][s2.length()+1];
        if(n1+n2!=n3) return false;
        
        return valid(s1,s2,s3,0,0,0,dp); 
        
}
}