class Solution {
    public int maxOperations(String s) {
        int oneC=0,i=0,tot=0;
        while(i<s.length()){
            if(s.charAt(i)=='1'){
                oneC++;
                i++;
            }else{
                tot+=oneC;
                while(i<s.length() && s.charAt(i)=='0'){
                    i++;
                }
            }
        }
        return tot;
    }
}