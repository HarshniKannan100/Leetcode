class Solution {
    public int minimumCost(int[] cost) {
        int sum=0;
        Arrays.sort(cost);
        for(int i=cost.length-1;i>=0;i-=3){
            sum+=i==0?cost[i]:cost[i]+cost[i-1];
        }
        return sum;
    }
}