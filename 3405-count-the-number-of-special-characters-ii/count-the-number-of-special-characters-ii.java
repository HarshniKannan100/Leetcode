class Solution {
    public int numberOfSpecialChars(String word) {
        int[] small=new int[26];
        int[] cap=new int[26];
        int cnt=0;
        for(char ch:word.toCharArray()){
            if(ch>='a' && ch<='z'){
                if(cap[ch-'a']==1){
                    cap[ch-'a']=-1;
                    small[ch-'a']=0;
                    cnt--;
                }else{
                    small[ch-'a']=1;
                }
            }else{
                if(small[ch-'A']==1 && cap[ch-'A']==0){
                    cnt++;
                    cap[ch-'A']=1;
                }else if(small[ch-'A']==0 && cap[ch-'A']==0){
                    cap[ch-'A']=-1;
                }
            }
        }
        return cnt;
    }
}