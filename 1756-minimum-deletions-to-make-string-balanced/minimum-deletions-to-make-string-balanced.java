class Solution {
    public int minimumDeletions(String s) {
        int[] pre=new int[s.length()];
        int[] suf=new int[s.length()];
        pre[0]=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)=='b'){
                pre[i]=1;
            }
            pre[i]+=pre[i-1];
        }
        suf[s.length()-1]=0;
        for(int i=s.length()-2;i>=0;i--){
            if(s.charAt(i+1)=='a'){
                suf[i]=1;
            }
            suf[i]+=suf[i+1];
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            min=Math.min(min,pre[i]+suf[i]);
        }
        return min;
    }
}