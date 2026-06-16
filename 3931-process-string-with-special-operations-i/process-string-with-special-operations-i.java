class Solution {
    public String processStr(String s) {
        StringBuilder res=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*' && res.length()!=0){
                res.deleteCharAt(res.length()-1);
            }else if(s.charAt(i)=='#'){
                res.append(res);
            }else if(s.charAt(i)=='%'){
                res.reverse();
            }else if(s.charAt(i)!='*'){
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}