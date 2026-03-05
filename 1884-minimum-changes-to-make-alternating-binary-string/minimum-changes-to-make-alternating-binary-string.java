class Solution {
    public int minOperations(String s) {
        int st=0,c=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)-'0'!=st) c++;
            st=st==0?1:0;
        }
        st=1;
        int c1=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)-'0'!=st) c1++;
            st=st==0?1:0;
        }
        return Math.min(c1,c);
    }
}