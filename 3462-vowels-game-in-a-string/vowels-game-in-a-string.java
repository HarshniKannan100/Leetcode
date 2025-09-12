class Solution {
    public boolean doesAliceWin(String s) {
        int vcount=0;
        for(char ch:s.toCharArray()){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                vcount++;
            }
        }
        if(vcount==0) return false;
        else return true;
    }
}