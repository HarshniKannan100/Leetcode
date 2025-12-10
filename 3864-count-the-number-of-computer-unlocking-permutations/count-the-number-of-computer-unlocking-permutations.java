class Solution {
    int mod=1000000007;
    long fact(int n){
        if(n==0 || n==1) return n;
        return (n*fact(n-1))%mod; 
    }
    public int countPermutations(int[] complexity) {
        if(complexity[0]==complexity[1]) return 0;
        for(int i=1;i<complexity.length;i++){
            if(complexity[i]<=complexity[0]) return 0;
        }
        return (int)fact(complexity.length-1);
    }
}