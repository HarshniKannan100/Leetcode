class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int C=encodedText.length()/rows;
        char[][] mat=new char[rows][C];
        for(int i=0;i<rows;i++){
            for(int j=0;j<C;j++){
                if((i*C)+j+i>=encodedText.length()) break;
                mat[i][j]=encodedText.charAt((i*C)+j+i);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<C;j++){
            for(int i=0;i<rows;i++){
                sb.append(mat[i][j]);
            }
        }
        int r=sb.length()-1;
        while(r>=0 && !Character.isLetter(sb.charAt(r))) r--;
        if(r==-1) return "";
        return sb.substring(0,r+1).toString();
    }
}