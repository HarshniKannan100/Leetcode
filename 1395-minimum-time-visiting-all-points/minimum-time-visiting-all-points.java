class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int sum=0;
        for(int i=0;i<points.length-1;i++){
            int d1=Math.abs(points[i+1][0]-points[i][0]);
            int d2=Math.abs(points[i+1][1]-points[i][1]);
            if(d1==d2) sum+=d1;
            else sum+=Math.min(d1,d2)+Math.abs(d1-d2);
        }
        return sum;
    }
}