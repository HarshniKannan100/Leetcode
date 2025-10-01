class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total=0,rem=numBottles;
        while(rem>=numExchange){
            total+=numBottles;
            numBottles=rem/numExchange;
            rem=(rem%numExchange) + (rem/numExchange);
        }
        total+=numBottles;
        return total;
    }
}