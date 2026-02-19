class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }
        Queue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int v:freq){
            if(v>0){
                pq.add(v);
            }
        }
        int time=0;
        Queue<int[]> q=new LinkedList<>();
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(pq.isEmpty()){
                time=q.peek()[1];
            }else{
                int c=pq.poll()-1;
                if(c>0) q.add(new int[]{c,time+n});
            }
            if(!q.isEmpty() && q.peek()[1]==time){
                pq.add(q.poll()[0]);
            }
        }
        return time;
    }
}
