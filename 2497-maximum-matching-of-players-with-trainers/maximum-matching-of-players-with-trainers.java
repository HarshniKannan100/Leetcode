class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int p=0,t=0,count=0;
        while(p<players.length && t<trainers.length){
            if(trainers[t]>=players[p]){
                count++;
                p++;
            }
            t++;
        }
        return count;
    }
}