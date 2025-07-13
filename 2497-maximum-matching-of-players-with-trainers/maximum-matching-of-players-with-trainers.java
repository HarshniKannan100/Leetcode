class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Queue<Integer> p=new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> t=new PriorityQueue<>(Collections.reverseOrder()); 
        for (int i=0;i<players.length;i++){
            p.add(players[i]);
        }     
        for(int i=0;i<trainers.length;i++){
            t.add(trainers[i]);
        }
        int count=0;
        while(!p.isEmpty() && !t.isEmpty()){
            if(p.element()<=t.element()){
                p.poll();
                t.poll();
                count++;
            }else{
                p.poll();
            }
        }
        return count;
    }
}