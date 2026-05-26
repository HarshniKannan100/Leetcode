class Solution {
    public int numberOfSpecialChars(String word) {
        int[] s=new int[26];
        int[] c=new int[26];
        for(char ch:word.toCharArray()){
            if(ch>='a' && ch<='z'){
                s[ch-'a']++;
            }else c[ch-'A']++;
        }
        int cnt=0;
        for(int i=0;i<26;i++){
            if(s[i]!=0 && c[i]!=0) cnt++;
        }
        return cnt;
    }
}