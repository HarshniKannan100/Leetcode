class Solution {
        public int smallestNumber(int n) {
        int val=2;
        while(val<=n){
            val=val*2;
        }
        return val-1;
    }
}