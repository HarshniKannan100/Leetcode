class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int max=0;
        int N=bottomLeft.length;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                int maxx=Math.max(bottomLeft[i][0],bottomLeft[j][0]);
                int minx=Math.min(topRight[i][0],topRight[j][0]);
                int maxy=Math.max(bottomLeft[i][1],bottomLeft[j][1]);
                int miny=Math.min(topRight[i][1],topRight[j][1]);
                if(maxx<minx && maxy<miny){
                    int len=Math.min(minx-maxx,miny-maxy);
                    max=Math.max(max,len);
                }
            }
        }
        return (long) max*max;
    }
}