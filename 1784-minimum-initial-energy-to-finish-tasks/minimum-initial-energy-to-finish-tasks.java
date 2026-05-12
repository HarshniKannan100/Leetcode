class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks,(a,b)->(b[1]-b[0])-(a[1]-a[0]));
        int max=0,sum=0;
        for(int i=0;i<tasks.length;i++){
            max=Math.max(max,tasks[i][1]+sum);
            sum+=tasks[i][0];
        }
        return max;
    }
}