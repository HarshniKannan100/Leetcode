class Solution {
    public String largestGoodInteger(String num) {
        int max=-1;
        for(int i=2;i<num.length();i++){
            if(num.charAt(i)==num.charAt(i-1) && num.charAt(i)==num.charAt(i-2)){
                max=Math.max(num.charAt(i)-'0',max);
            }
        }
        if(max==-1) return "";
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<3;i++)
        sb.append(Integer.toString(max));
        return sb.toString();
    }
}