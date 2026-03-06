class Solution {
    public boolean checkOnesSegment(String s) {
        boolean flag=false;
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='1'){
                if(!flag){
                    while(i<s.length() && s.charAt(i)=='1') i++;
                    flag=true;
                }else{
                    return false;
                }
            }
            i++;
        }
        return flag;
    }
}