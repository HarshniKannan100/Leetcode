class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxsq=0;
        int maxarea=0;
        for(int d[]:dimensions){
            int sq=0;
            int prod=1;
            for(int v:d){
                sq+=v*v;
                prod*=v;
                if(sq>maxsq || (sq==maxsq && prod>maxarea)){
                    maxsq=sq;
                    maxarea=prod;
                }
            }

            
        }
        return maxarea;
    }
}