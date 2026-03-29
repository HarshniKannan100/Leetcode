class Solution {
    public boolean canBeEqual(String s1, String s2) {
        for(int i=0;i<4;i++){
            if(i%2==0){
                if(s1.charAt(i)!=s2.charAt(0) && s1.charAt(i)!=s2.charAt(2)) return false;
            }else{
                if(s1.charAt(i)!=s2.charAt(1) && s1.charAt(i)!=s2.charAt(3)) return false;
            }
        }
        return true;
    }
}