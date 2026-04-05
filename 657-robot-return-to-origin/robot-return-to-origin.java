class Solution {
    public boolean judgeCircle(String moves) {
        int ud=0,lr=0;
        for(char ch:moves.toCharArray()){
            if(ch=='L') lr++;
            else if(ch=='R') lr--;
            else if(ch=='U') ud++;
            else ud--;
        }
        return lr==0 && ud==0;
    }
}