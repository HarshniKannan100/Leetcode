class Solution {
    public int bitwiseComplement(int n) {
        int len=(int)(Math.log(n)/Math.log(2))+1;
        int m=(1<<len)-1;
        return n^m;
    }
}