class Solution {
    public int minFlips(String s) {
        int n=s.length();
        String ss=s+s;
        int ans=n,mis0=0;
        for(int i=0;i<n*2;i++){
            char exp=(i%2==0)?'0':'1';
            if(ss.charAt(i)!=exp) mis0++;
            if(i>=n){
                int left=i-n;
                char expLeft=(left%2==0)?'0':'1';
                if(ss.charAt(left)!=expLeft) mis0--;
            }
            if(i>=n-1){
                int mis1=n-mis0;
                ans=Math.min(ans,Math.min(mis0,mis1));
            }
        }
        return ans;
    }
}