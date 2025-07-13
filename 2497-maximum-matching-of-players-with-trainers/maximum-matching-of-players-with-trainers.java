class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int t=0,count=0;
        for(int p:players){
        while(t<trainers.length && trainers[t]<p){
            t++;
        }
            if(t==trainers.length) return count;
            else{
                count++;
                t++;
            }
        }
        return count;
    }
}