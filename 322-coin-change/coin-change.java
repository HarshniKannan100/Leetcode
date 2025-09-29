class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] min=new int[amount+1];
        Arrays.fill(min,amount+1);
        min[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0){
                    min[i]=Math.min(min[i],1+min[i-coins[j]]);
                }
            }
        }
        return min[amount]==amount+1?-1:min[amount];
    }
}