class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] right=new int[26];
        int[] left=new int[26];
        for(int i=0;i<s.length();i++){
            right[s.charAt(i)-'a']++;
        }   
        left[s.charAt(0)-'a']++;
        right[s.charAt(0)-'a']--;
        Set<String> set=new HashSet<>();
        
        for(int c=1;c<s.length()-1;c++){
            right[s.charAt(c)-'a']--;
            for(int i=0;i<26;i++){
                if(left[i]*right[i]!=0){
                    StringBuilder sb=new StringBuilder();
                    sb.append((char)(i+'a')).append(s.charAt(c)).append((char)(i+'a'));
                    set.add(sb.toString());
                }
            }
            left[s.charAt(c)-'a']++;
        }
        return set.size();
    }
}