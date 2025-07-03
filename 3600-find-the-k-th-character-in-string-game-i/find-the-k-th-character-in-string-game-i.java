class Solution {
    public char kthCharacter(int k) {
        StringBuilder word=new StringBuilder();
        word.append("a");
        while(word.length()<k){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<word.length();i++){
                if(word.charAt(i)=='z') sb.append("a");
                else sb.append((char)(word.charAt(i)+1));
            }
            word.append(sb);
        }
        return word.charAt(k-1);
    }
}