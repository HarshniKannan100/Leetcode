class Solution {
    static long even(int n){
        return (n>1)?n/2:0;
    }

    static long odd(int n){
        return (n%2==0)?n/2:(n/2)+1;
    }
    public long flowerGame(int n, int m) {
        long even=even(n)*odd(m);
        long odd=odd(n)*even(m);
        return even+odd;
    }
}