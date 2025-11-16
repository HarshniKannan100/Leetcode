class Solution {
    public int numSub(String s) {
        long count=0,tot=0;
        for(char ch:s.toCharArray()){
            if(ch=='1'){
                count++;
                tot=(tot+count)%1000000007;
            }else count=0;
        }
        return (int) tot;
    }
}