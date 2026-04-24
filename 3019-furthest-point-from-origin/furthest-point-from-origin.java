class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int sum=0,dash=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L') sum--;
            else if(moves.charAt(i)=='R') sum++;
            else dash++;
        }
        return Math.max(sum+dash,Math.abs(sum-dash));
    }
}