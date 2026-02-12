class Solution {
    public int longestBalanced(String s) {
        int maxlen=1;
        for(int i=0;i<s.length();i++){
            int max=1,maxcount=1;
            int[] freq=new int[26];
            freq[s.charAt(i)-'a']++;
            Set<Character> set=new HashSet<>();
            set.add(s.charAt(i));
            for(int j=i+1;j<s.length();j++){
                int idx=s.charAt(j)-'a';
                freq[idx]++;
                if(freq[idx]>max){
                    max=freq[idx];
                    maxcount=1;
                }else if(freq[idx]==max){
                    maxcount++;
                }
                set.add(s.charAt(j));
                if(maxcount==set.size()){
                    maxlen=Math.max(maxlen,j-i+1);
                }
            }
        }
        return maxlen;
    }
}