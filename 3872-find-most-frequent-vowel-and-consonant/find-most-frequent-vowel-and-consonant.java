class Solution {
    public int maxFreqSum(String s) {
        int[] freq=new int[26];
        int cc=0,vc=0;
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(i==0 ||i==4 || i==8 || i==14 || i==20) vc=Math.max(vc,freq[i]);
            else cc=Math.max(cc,freq[i]);
        }
        return cc+vc;
    }
}