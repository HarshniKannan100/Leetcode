class Solution {
    public boolean judgeCircle(String moves) {
        int[] f=new int[4];
        for(char ch:moves.toCharArray()){
            if(ch=='L') f[0]++;
            else if(ch=='R') f[1]++;
            else if(ch=='U') f[2]++;
            else f[3]++;
        }
        return f[0]==f[1] && f[2]==f[3];
    }
}