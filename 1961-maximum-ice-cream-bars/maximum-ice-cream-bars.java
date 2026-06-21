class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int sum=0;
        for(int i=0;i<costs.length;i++){
            if(sum+costs[i]>coins) return i;
            else if(sum+costs[i]==coins) return i+1;
            sum+=costs[i];
        }
        return costs.length;
    }
}