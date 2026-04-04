class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int C=encodedText.length()/rows;
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<C;j++){
            for(int i=0;i<rows;i++){
                if(((i*C)+j+i)>=encodedText.length()){
                    break;
                }
                sb.append(encodedText.charAt((i*C)+j+i));
            }
        }
        int r=sb.length()-1;
        while(r>=0 && !Character.isLetter(sb.charAt(r))) r--;
        if(r==-1) return "";
        return sb.substring(0,r+1).toString();
    }
}