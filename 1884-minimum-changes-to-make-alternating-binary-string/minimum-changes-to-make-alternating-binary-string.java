class Solution {
    public int minOperations(String s) {
        int st=0,c=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)-'0'!=st) c++;
            st^=1;
        }
        return Math.min(c,s.length()-c);
    }
}