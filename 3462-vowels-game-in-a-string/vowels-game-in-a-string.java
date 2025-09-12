class Solution {
    public boolean doesAliceWin(String s) {
        int vcount=0;
        for(char ch:s.toCharArray()){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                vcount++;
            }
        }
        if(vcount==0) return false;
        else if(vcount%2!=0) return true;
        else return true;
    }
}