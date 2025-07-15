class Solution {
    public boolean isValid(String word) {
    if(word.length()<3) return false;
    boolean vowel=false;
    boolean con=false;
    for(char ch:word.toCharArray()){
        if(!Character.isLetterOrDigit(ch)) return false; 
        
        if(Character.isLetter(ch)){
        ch=Character.toLowerCase(ch);
        if((!vowel) && (ch=='a' || ch=='e' || ch=='i' || ch=='o' ||ch=='u')){
            vowel=true;
        }

        if((!con) && (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u')){
    con = true;
}

        
        }
    }
    if(vowel && con) return true;
    return false;
    }
}