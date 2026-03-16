class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q=new LinkedList<>();
        boolean[] vis=new boolean[arr.length];
        q.add(start);
        while(!q.isEmpty()){
            int poll=q.poll();
            vis[poll]=true;
            if(arr[poll]==0) return true;
            if(poll+arr[poll]<=arr.length-1 && !vis[poll+arr[poll]]){
                q.add(poll+arr[poll]);
            }
            if(poll-arr[poll]>=0 && !vis[poll-arr[poll]]){
                q.add(poll-arr[poll]);
            }
        }
        return false;
    }
}