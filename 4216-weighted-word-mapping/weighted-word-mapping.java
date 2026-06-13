class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String res="";
        for(String s:words){
            int sum=0;
            for(char ch:s.toCharArray()){
                sum+=weights[ch-'a'];
            }
            sum%=26;
            res=res+((char)('a'+26-sum-1));
        }
        return res;
    }
}