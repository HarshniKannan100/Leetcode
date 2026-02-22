class Solution {
    public int binaryGap(int n) {
        boolean first=false;
        int dist=0,max=0;
        while(n>0){
            int v=n%2;
            if(v==1){
                if(!first){
                    first=true;
                    dist=1;
                }else{
                    max=Math.max(dist,max);
                    dist=1;
                }
            }else if(first){
                dist++;
            }
            n/=2;
        }
        return max;
    }
}